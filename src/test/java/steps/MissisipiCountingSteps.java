package steps;

import org.jbehave.core.annotations.When;

public class MissisipiCountingSteps extends AbstractCountingStep{

    @When("$name counts to $n Mississippi.")
    public void whenSomeoneCountsMississippis(String name, int n) throws InterruptedException {

        int i = 0;
        long start = System.currentTimeMillis();
        while(i<=n){
            String message = name +" says " + i + " Mississippi. [Thread:  " + Thread.currentThread().getId() + " After " + (System.currentTimeMillis() - start)/1000L + " secs.]";
            System.out.println(message);
            LOG.info(message);
            Thread.sleep(1000);
            i++;
        }
        System.setProperty( String.valueOf(name.toLowerCase())+"Finished", "true");
    }
}