package br.com.educamais.app.mock

import br.com.educamais.app.model.Aula
import br.com.educamais.app.model.Curso
import br.com.educamais.app.model.Modulo
import br.com.educamais.app.model.RiscoEvasao
import br.com.educamais.app.model.TipoAula

val cursos: List<Curso> = listOf(
    Curso(
        id = "bpf",
        titulo = "Boas Práticas de Fabricação (BPF)",
        categoria = "Qualidade",
        instrutor = "Fernanda Ristow",
        descricao = "Fundamentos de BPF para colaboradores da produção farmacêutica, " +
            "alinhados à RDC 658/2022 da Anvisa.",
        cargaHoraria = 6,
        progresso = 1f,
        risco = RiscoEvasao.BAIXO,
        obrigatorio = true,
        prazo = "20/09/2026",
        modulos = listOf(
            Modulo(
                titulo = "Fundamentos de BPF",
                aulas = listOf(
                    Aula("Introdução às Boas Práticas de Fabricação", 14, TipoAula.VIDEO, true),
                    Aula("Contaminação cruzada: causas e prevenção", 18, TipoAula.VIDEO, true),
                    Aula("Quiz: princípios de BPF", 10, TipoAula.QUIZ, true)
                )
            ),
            Modulo(
                titulo = "Documentação e Rastreabilidade",
                aulas = listOf(
                    Aula("Registros de lote e rastreabilidade", 16, TipoAula.VIDEO, true),
                    Aula("Procedimentos operacionais padrão (POPs)", 12, TipoAula.LEITURA, true),
                    Aula("Quiz: documentação BPF", 8, TipoAula.QUIZ, true)
                )
            )
        )
    ),
    Curso(
        id = "farmacovigilancia",
        titulo = "Farmacovigilância na Prática",
        categoria = "Farmacovigilância",
        instrutor = "Dr. Ricardo Bonfim",
        descricao = "Como identificar, registrar e notificar eventos adversos e queixas " +
            "técnicas relacionados a medicamentos.",
        cargaHoraria = 5,
        progresso = 0.4f,
        risco = RiscoEvasao.MEDIO,
        obrigatorio = true,
        prazo = "05/10/2026",
        modulos = listOf(
            Modulo(
                titulo = "Fundamentos de Farmacovigilância",
                aulas = listOf(
                    Aula("O que é farmacovigilância e por que ela importa", 12, TipoAula.VIDEO, true),
                    Aula("Eventos adversos: classificação e gravidade", 15, TipoAula.VIDEO, true)
                )
            ),
            Modulo(
                titulo = "Notificação de Eventos Adversos",
                aulas = listOf(
                    Aula("Como notificar um evento adverso no sistema VigiMed", 20, TipoAula.VIDEO, false),
                    Aula("Estudo de caso: queixa técnica de lote", 14, TipoAula.LEITURA, false),
                    Aula("Quiz: fluxo de notificação", 10, TipoAula.QUIZ, false)
                )
            )
        )
    ),
    Curso(
        id = "lgpd",
        titulo = "LGPD Aplicada à Indústria Farmacêutica",
        categoria = "Compliance",
        instrutor = "Camila Nogueira",
        descricao = "Proteção de dados pessoais de pacientes, médicos e colaboradores nos " +
            "processos da indústria farmacêutica.",
        cargaHoraria = 4,
        progresso = 0.5f,
        risco = RiscoEvasao.BAIXO,
        obrigatorio = true,
        prazo = "30/09/2026",
        modulos = listOf(
            Modulo(
                titulo = "Fundamentos da LGPD",
                aulas = listOf(
                    Aula("Princípios da Lei Geral de Proteção de Dados", 13, TipoAula.VIDEO, true),
                    Aula("Dados sensíveis: informações de saúde e farmacovigilância", 15, TipoAula.VIDEO, true)
                )
            ),
            Modulo(
                titulo = "LGPD no Dia a Dia",
                aulas = listOf(
                    Aula("Protocolo de resposta a incidentes de dados", 12, TipoAula.LEITURA, false),
                    Aula("Quiz: aplicação prática da LGPD", 9, TipoAula.QUIZ, false)
                )
            )
        )
    ),
    Curso(
        id = "ssma",
        titulo = "Segurança do Trabalho em Ambiente Fabril",
        categoria = "SSMA",
        instrutor = "Paulo Sérgio Andrade",
        descricao = "Prevenção de acidentes, uso correto de EPIs e procedimentos de " +
            "emergência nas linhas de produção.",
        cargaHoraria = 5,
        progresso = 0f,
        risco = RiscoEvasao.ALTO,
        obrigatorio = true,
        prazo = "15/09/2026",
        modulos = listOf(
            Modulo(
                titulo = "Prevenção de Acidentes",
                aulas = listOf(
                    Aula("Uso correto de EPIs na linha de produção", 14, TipoAula.VIDEO, false),
                    Aula("Identificação de riscos em ambiente fabril", 16, TipoAula.VIDEO, false),
                    Aula("Quiz: prevenção de acidentes", 8, TipoAula.QUIZ, false)
                )
            ),
            Modulo(
                titulo = "Procedimentos de Emergência",
                aulas = listOf(
                    Aula("Rotas de fuga e brigada de incêndio", 12, TipoAula.VIDEO, false),
                    Aula("Simulado de evacuação: estudo de caso", 10, TipoAula.LEITURA, false)
                )
            )
        )
    ),
    Curso(
        id = "validacao",
        titulo = "Validação de Processos Produtivos",
        categoria = "Qualidade",
        instrutor = "Eng. Marina Kobayashi",
        descricao = "Metodologia de qualificação e validação de equipamentos e processos " +
            "produtivos farmacêuticos.",
        cargaHoraria = 7,
        progresso = 0.4f,
        risco = RiscoEvasao.MEDIO,
        obrigatorio = true,
        prazo = "10/11/2026",
        modulos = listOf(
            Modulo(
                titulo = "Fundamentos de Validação",
                aulas = listOf(
                    Aula("Conceitos de qualificação: IQ, OQ e PQ", 18, TipoAula.VIDEO, true),
                    Aula("Protocolo de validação: estrutura e etapas", 15, TipoAula.LEITURA, true)
                )
            ),
            Modulo(
                titulo = "Validação na Prática",
                aulas = listOf(
                    Aula("Estudo de caso: validação de processo de envase", 20, TipoAula.VIDEO, false),
                    Aula("Análise de desvios em validação", 14, TipoAula.LEITURA, false),
                    Aula("Quiz: validação de processos", 10, TipoAula.QUIZ, false)
                )
            )
        )
    ),
    Curso(
        id = "comunicacao",
        titulo = "Comunicação Assertiva com Times",
        categoria = "Comportamental",
        instrutor = "Juliana Prado",
        descricao = "Técnicas de comunicação para lideranças e times multidisciplinares em " +
            "ambiente fabril e corporativo.",
        cargaHoraria = 3,
        progresso = 0f,
        risco = RiscoEvasao.BAIXO,
        obrigatorio = false,
        prazo = "01/12/2026",
        modulos = listOf(
            Modulo(
                titulo = "Fundamentos da Comunicação Assertiva",
                aulas = listOf(
                    Aula("Comunicação não violenta no ambiente de trabalho", 12, TipoAula.VIDEO, false),
                    Aula("Feedback construtivo entre times", 14, TipoAula.VIDEO, false)
                )
            ),
            Modulo(
                titulo = "Aplicação Prática",
                aulas = listOf(
                    Aula("Simulação ao vivo: conversas difíceis", 16, TipoAula.AO_VIVO, false)
                )
            )
        )
    ),
    Curso(
        id = "compliance",
        titulo = "Compliance e Código de Conduta",
        categoria = "Compliance",
        instrutor = "Rodrigo Feitosa",
        descricao = "Diretrizes anticorrupção, conflito de interesses e relacionamento com " +
            "profissionais de saúde.",
        cargaHoraria = 4,
        progresso = 0.75f,
        risco = RiscoEvasao.BAIXO,
        obrigatorio = true,
        prazo = "25/09/2026",
        modulos = listOf(
            Modulo(
                titulo = "Código de Conduta",
                aulas = listOf(
                    Aula("Princípios éticos e código de conduta corporativo", 12, TipoAula.VIDEO, true),
                    Aula("Conflito de interesses: como identificar", 10, TipoAula.LEITURA, true)
                )
            ),
            Modulo(
                titulo = "Relacionamento com Profissionais de Saúde",
                aulas = listOf(
                    Aula("Interações comerciais e brindes: o que é permitido", 14, TipoAula.VIDEO, true),
                    Aula("Quiz: compliance na prática", 8, TipoAula.QUIZ, false)
                )
            )
        )
    ),
    Curso(
        id = "excel",
        titulo = "Excel Avançado para Análise de Dados",
        categoria = "Produtividade",
        instrutor = "Tiago Almeida",
        descricao = "Fórmulas avançadas, tabelas dinâmicas e dashboards para análise de " +
            "indicadores de produção e qualidade.",
        cargaHoraria = 6,
        progresso = 0.25f,
        risco = RiscoEvasao.BAIXO,
        obrigatorio = false,
        prazo = "20/12/2026",
        modulos = listOf(
            Modulo(
                titulo = "Fórmulas e Funções Avançadas",
                aulas = listOf(
                    Aula("PROCV, ÍNDICE e CORRESP na prática", 18, TipoAula.VIDEO, true),
                    Aula("Fórmulas condicionais e SOMASES", 15, TipoAula.VIDEO, false)
                )
            ),
            Modulo(
                titulo = "Tabelas Dinâmicas e Dashboards",
                aulas = listOf(
                    Aula("Construindo tabelas dinâmicas do zero", 20, TipoAula.VIDEO, false),
                    Aula("Dashboards de indicadores de produção", 22, TipoAula.VIDEO, false)
                )
            )
        )
    )
)

fun buscarCursoPorId(id: String): Curso? = cursos.firstOrNull { it.id == id }

fun categoriasDeCursos(): List<String> = cursos.map { it.categoria }.distinct().sorted()

fun filtrarCursos(busca: String = "", categoria: String? = null): List<Curso> {
    return cursos.filter { curso ->
        val correspondeBusca = busca.isBlank() ||
            curso.titulo.contains(busca, ignoreCase = true) ||
            curso.instrutor.contains(busca, ignoreCase = true) ||
            curso.categoria.contains(busca, ignoreCase = true)
        val correspondeCategoria = categoria == null || curso.categoria == categoria
        correspondeBusca && correspondeCategoria
    }
}
