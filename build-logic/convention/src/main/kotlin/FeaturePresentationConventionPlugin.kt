import org.gradle.api.Plugin
import org.gradle.api.Project

class FeaturePresentationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("mymoneymate.android.library")
            }
        }
    }
}