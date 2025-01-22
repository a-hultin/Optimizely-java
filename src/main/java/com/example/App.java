package com.example;

import com.optimizely.ab.OptimizelyFactory;
import com.optimizely.ab.config.HttpProjectConfigManager;
import com.optimizely.ab.config.ProjectConfigManager;
import com.optimizely.ab.config.parser.JsonParseException;
import com.optimizely.ab.event.AsyncEventHandler;
import com.optimizely.ab.event.EventHandler;
import com.optimizely.ab.Optimizely;
import com.optimizely.ab.OptimizelyUserContext;
import com.optimizely.ab.optimizelydecision.OptimizelyDecision;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Hello world!
 *
 */
public class App 
{
            // EventHandler eventHandler = AsyncEventHandler.builder()
        //     .withQueueCapacity(20000)
        //     .withNumWorkers(5)
        //     .build();

        // ProjectConfigManager projectConfigManager = HttpProjectConfigManager.builder()
        //     .withSdkKey(sdkKey)
        //     .withPollingInterval(1L, TimeUnit.MINUTES)
        //     .withDatafileAccessToken("BSxRteB2")
        //     //.withUrl("https://optimizely.teliacompany.com/cdn/datafiles/BsXrTeB2Cv7ACQAFJWjsA.json")
        //     //.withDatafile("https://optimizely.teliacompany.com/cdn/datafiles/BsXrTeB2Cv7ACQAFJWjsA.json")
        //     .build();

        // Optimizely optimizelyClient = Optimizely.builder()
        //     .withEventHandler(eventHandler)
        //     .withConfigManager(projectConfigManager)
        //     .build();

    private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.info( "Hello World!" );
        String sdkKey = "BsXrTeB2Cv7ACQAFJWjsA";


        // this Optimizely initialization is synchronous. for other methods see the Java SDK reference
        Optimizely optimizelyClient = OptimizelyFactory.newDefaultInstance(sdkKey);
        if (optimizelyClient.isValid()) {
            /* --------------------------------
             * to get rapid demo results, generate random users. Each user always sees the same variation unless you reconfigure the flag rule.
             * --------------------------------
             */
            logger.info(sdkKey + " is valid!!");
            Random rnd = new Random();

            boolean hasOnFlags = false;

            for (int i = 0; i < 10; i++) {
                String userId = (rnd.nextInt(9999 - 1000) + 1000) + "";
                /* --------------------------------
                   Create hardcoded user & bucket user into a flag variation
                   -------------------------------
                 */
                OptimizelyUserContext user = optimizelyClient.createUserContext(userId);
                // "product_sort" corresponds to a flag key in your Optimizely project
                OptimizelyDecision decision = user.decide("product_sort");
                // did decision fail with a critical error?
                if (decision.getVariationKey() == null) {
                    System.out.println("\n\ndecision error: " + decision.getReasons());
                }
                // get a dynamic configuration variable
                // "sort_method" corresponds to a variable key in your Optimizely project
                String sortMethod = null;
                try {
                    sortMethod = decision.getVariables().getValue("sort_method", String.class);
                } catch (JsonParseException e) {
                    e.printStackTrace();
                }

              	if (decision.getEnabled()) {
                    // Keep count how many visitors had the flag enabled
                    hasOnFlags = true;
                }
                /* --------------------------------
                   Mock what the users sees with print statements (in production, use flag variables to implement feature configuration)
                   --------------------------------
                */
                // always returns false until you enable a flag rule in your Optimizely project

              	System.out.println("\n\nFlag " + decision.getEnabled() + " for user " + userId + " with sort method: " + sortMethod);

            }

            if (!hasOnFlags) {
                System.out.println("\n\nFlag was off for everyone. Some reasons could include:" +
                        "\n1. Your sample size of visitors was too small. Rerun, or increase the iterations in the FOR loop" +
                        "\n2. By default you have 2 keys for 2 project environments (dev/prod). Verify in Settings>Environments that you used the right key for the environment where your flag is toggled to ON." +
                        "\n\nCheck your key at  https://app.optimizely.com/v2/projects/" + optimizelyClient.getProjectConfig().getProjectId() + "settings/implementation");
            }
        } else {
            logger.info("Optimizely client invalid. Verify in Settings>Environments that you used the primary environment's SDK key");
        }
        // close before exit to flush out queued events
        optimizelyClient.close();
    }
    
}
