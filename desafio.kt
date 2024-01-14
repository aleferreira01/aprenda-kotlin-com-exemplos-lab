// [Template no Kotlin Playground](https://pl.kotl.in/h7_Q1zNYx)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val nivel: Nivel, val duracao: Int) {

    override fun toString(): String {
        return """
            Nome: $nome, Nível: $nivel, Duração: $duracao hrs 
        """.trimEnd()
    }
}

data class Formacao(val nome: String, val nivel: Nivel, val duracao: Int, val conteudos: List<ConteudoEducacional>) {

    private val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
        println("Lista de usuários cadastrados com sucesso")
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} cadastrado com sucesso")
    }

    private fun contarMatriculas() = inscritos.size

    override fun toString(): String {
        return """
            
        FORMAÇÃO 
        
        Nome: $nome,
        Nível: $nivel,
        Duração: $duracao hrs
        Matrículas: ${contarMatriculas()} usuários cadastrados 
        
        CONTEÚDOS            
        ${conteudos.toString().removeSurrounding("[","]")}
                
        """.trimIndent()
    }
}

fun main() {

    val cursoKotlin = ConteudoEducacional("Conhecendo o Kotlin", Nivel.BASICO, 1)
    val cursoPOO = ConteudoEducacional("Orientação a Objetos e Tipos de Classes", Nivel.INTERMEDIARIO, 2)
    val cursoSpring = ConteudoEducacional("Desenvolvimento Web com Spring Boot", Nivel.AVANCADO, 4)
    val listaConteudos = listOf(cursoKotlin,cursoPOO,cursoSpring)

    val kotlinDeveloper = Formacao("Backend com Kotlin", Nivel.BASICO, 52, listaConteudos)
    kotlinDeveloper.matricular(Usuario("João"), Usuario("Maria"), Usuario("Marcos"))
    kotlinDeveloper.matricular(Usuario("Gabriela"))

    println(kotlinDeveloper)
}
