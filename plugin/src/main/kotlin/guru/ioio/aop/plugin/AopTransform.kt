package guru.ioio.aop.plugin

import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import org.gradle.api.Project

class AopTransform(private val mProject: Project) : Transform() {
    override fun getName() = "aop"

    override fun getInputTypes() = mutableSetOf(QualifiedContent.DefaultContentType.CLASSES)

    override fun getScopes(): MutableSet<QualifiedContent.ScopeType> =
        TransformManager.SCOPE_FULL_PROJECT

    override fun isIncremental(): Boolean = true

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
        println("*** transform ***")
        transformInvocation?.apply {
            println("projectName=${context.projectName}, path=${context.path}, variant=${context.variantName}, isIncremental=${isIncremental}")
            inputs.forEach { input ->
                input.jarInputs.forEach {
                    println("jarInput: ${it.file.absolutePath}")
                }
                input.directoryInputs.forEach {
                    println("dirInput: ${it.file.absolutePath}")
                }
            }
        }
    }
}