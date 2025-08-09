import com.vn.mymoneymate.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KMPRoomPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.run {
            apply("org.jetbrains.kotlin.plugin.serialization")
            apply("com.google.devtools.ksp")
            apply("androidx.room")
        }

        dependencies {
            add("commonMainImplementation", libs.findLibrary("kotlinx-datetime").get())
            add("commonMainImplementation", libs.findLibrary("androidx-room-runtime").get())
            add("commonMainImplementation", libs.findLibrary("sqlite-bundled").get())
        }
    }
}