// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        usuario.takeUnless { inscritos.contains(usuario) }
            ?.also {
                inscritos.add(it)
                println("Usuário ${it.nome} matriculado.")
            }
            ?: println("Usuário já está matriculado.")
    }
}

fun main() {
    val kotlin = ConteudoEducacional("Curso Kotlin", Nivel.BASICO, 60)
    val java = ConteudoEducacional("Curso Java", Nivel.INTERMEDIARIO, 60)

    val android = Formacao("Formação Android", listOf(kotlin, java))

    val a = Usuario("João")
    val b = Usuario("Maria")

    android.matricular(a)
    android.matricular(b)
    android.matricular(b)
}