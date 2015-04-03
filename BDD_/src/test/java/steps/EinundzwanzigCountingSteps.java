package steps;

import org.jbehave.core.annotations.When;

/**
 * Created by 212427754 on 2015.01.06..
 */
public class EinundzwanzigCountingSteps extends AbstractCountingStep {

    @When("$name counts to $n einundzwanzig.")
    public void whenSomeoneCountsEinundzwanzigs(String name, int n) throws InterruptedException {

        while(!System.getProperty("huckFinished").equals("true") && !System.getProperty("tomFinished").equals("true")){
            Thread.sleep(1000);
        }
        int i = 0;
        long start = System.currentTimeMillis();
        while(i<=n){
            String message =name +" count the " + i + ". einundzwanzig. [Thread:  " + Thread.currentThread().getId() + " After " + (System.currentTimeMillis() - start)/1000L + " secs.]";
            System.out.println(message);
            LOG.info(message);
            Thread.sleep(1000);
            i++;
        }
        System.setProperty( String.valueOf(name.toLowerCase())+"Finished", "true");
    }
}
