package business

// implementar logica = regras de negocio
// é uma classe que possui acoes (salvar e deletar), nem precisa dos atributos

class ContactBusiness {

    // trabalhando com controle de fluxo e excecao
    fun validate(name: String, phone: String) {
        if (name == "") {
            throw Exception("Nome é obrigatório")
        }

        if (phone == "") {
            throw Exception("Telefone é obrigatório")
        }
    }

    fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É necessário selecionar um contato antes de remover")
        }

    }

    fun save(name: String, phone: String) {
        validate(name, phone)
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone)
    }
}