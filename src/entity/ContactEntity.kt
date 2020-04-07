package entity

// responsavel por armazenar as entidades de dados (como uma classe de dados).
// É importante separar qdo precisamos salvar muitos campos diferentes. Para evitar muitos parametros numa funcao.
// é uma classe que tem ATRIBUTOS que sao esses DADOS

class ContactEntity (var name: String, var phone: String)