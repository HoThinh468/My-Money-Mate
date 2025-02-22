import com.android.build.gradle.LibraryExtension
import com.vn.mymoneymate.configureKMPAndroidExtension
import com.vn.mymoneymate.configureKMPExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KMPPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.multiplatform")
            pluginManager.apply("com.android.library")

            configureKMPExtension(extensions.getByType<KotlinMultiplatformExtension>())
            configureKMPAndroidExtension(extensions.getByType<LibraryExtension>())
        }
    }
}