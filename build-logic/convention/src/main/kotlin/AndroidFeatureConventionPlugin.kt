import com.vn.mymoneymate.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("mymoneymate.android.library")
            }

            dependencies {
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:utility"))
                add("implementation", libs.findLibrary("compose-ui").get())
                add("implementation", libs.findLibrary("compose-nav").get())
                add(
                    "implementation",
                    libs.findLibrary("compose-ui-tooling-preview").get()
                )
                add(
                    "implementation",
                    libs.findLibrary("compose-material3").get()
                )
                add(
                    "implementation",
                    libs.findLibrary("androidx-lifecycle-viewModelCompose").get()
                )
                add(
                    "implementation",
                    libs.findLibrary("androidx-activity-compose").get()
                )
            }
        }
    }
}