package repository

import entity.ContactEntity

// repositorio quem salva os dados da aplicacao
// repositorio precisa estar preparado para receber uma classe chamada entity

class ContactRepository {

    // permite que tudo seja persistido durante varias instacias, varias criacoes da classde, e nao se perca
    // ou seja, acessar ContactRepository ou acessar comnpanion esta acessado o mesmo conteudo
    companion object {

        // local para salvar os dados - variavel
        // criaremos uma lista para salvar os contatos
        private val contactList = mutableListOf<ContactEntity>()

        fun save(contact: ContactEntity) {
            contactList.add(contact)
        }

        fun delete(contact: ContactEntity) {
            //criar logica responsavel por deletar o contato da listagem

            // contactList.remove(contact)
            var index = 0
            for (item in contactList.withIndex()) {
                if (item.value.name == contact.name && item.value.phone == contact.phone) {
                    index = item.index
                    break
                }
            }
            contactList.removeAt(index)
        }

        // criar um metodo (este metodo sera uma funcao) que seja capaz de
        // retornar esses dados (uma lista de contatos)
        fun getList(): List<ContactEntity> { // sem declarar o tipo de base
            return contactList
        }
    }

}