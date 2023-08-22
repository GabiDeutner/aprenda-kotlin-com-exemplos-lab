enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(
    val nome: String,
    val descricao: String,
    val conteudos: List<ConteudoEducacional>,
    val aluno: Usuario,
    val nivel: List<Nivel>,
    val inscritos: MutableList<Usuario> = mutableListOf(),
) {
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("Gabi", "gabi@email.com")
    val usuario2 = Usuario("Jose", "jose@email.com")
    val usuario3 = Usuario("Rafa", "rafa@email.com")

    val conteudo1 = ConteudoEducacional("Orientação a Objetos com Kotlin", 50, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados com Kotlin", 90, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvendo um app Mobile no Android com Kotlin", 150, Nivel.DIFICIL)

    val formacao1 = Formacao(
        "Formação em POO com Kotlin",
        "Aprenda os conceitos fundamentais de POO com Kotlin",
        listOf(conteudo1, conteudo2),
        usuario1,
        listOf(Nivel.BASICO, Nivel.INTERMEDIARIO)
    )

    val formacao2 = Formacao(
        "Formação em Desenvolvimento Mobile Android com Kotlin",
        "Aprenda a desenvolver apps utilizando a linguagem Kotlin",
        listOf(conteudo2, conteudo3),
        usuario2,
        listOf(Nivel.INTERMEDIARIO, Nivel.DIFICIL)
    )

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario3)
    formacao2.matricular(usuario1)

    println("Alunos matriculados na Formação em POO com Kotlin:")
    formacao1.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, Email: ${aluno.email}")
    }

    println("\nAlunos matriculados na Formação em Desenvolvimento Mobile Android com Kotlin:")
    formacao2.inscritos.forEach { aluno ->
        println("Nome: ${aluno.nome}, Email: ${aluno.email}")
    }
}