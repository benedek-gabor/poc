package utils;


import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;




import steps.FirefoxSteps;
import steps.ChromeSteps;

import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;

public class ThreadsStories extends JUnitStories {

    public ThreadsStories() {
        Embedder embedder = configuredEmbedder();
        embedder.embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).doVerboseFiltering(true).useThreads(1).useStoryTimeoutInSecs(7).doFailOnStoryTimeout(false);
        embedder.useMetaFilters(Arrays.asList("groovy: story_path ==~ /.*long.*/"));
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryControls(new StoryControls().useStoryMetaPrefix("story_").useScenarioMetaPrefix("scenario_")) // optional prefixes
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                                .withDefaultFormats().withFormats(CONSOLE, HTML).withFailureTrace(true)
                                .withFailureTraceCompression(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ChromeSteps(), new FirefoxSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/*.feature", "");
    }

}