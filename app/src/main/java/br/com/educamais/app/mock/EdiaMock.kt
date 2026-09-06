package br.com.educamais.app.mock

import br.com.educamais.app.model.AutorMensagem
import br.com.educamais.app.model.MensagemEdia

val sugestoesDePergunta: List<String> = listOf(
    "O que é contaminação cruzada em BPF?",
    "Como notificar um evento adverso?",
    "Quais dados são considerados sensíveis pela LGPD?",
    "O que é um protocolo de validação?",
    "Qual é o meu progresso nos cursos?",
    "Quais salas de estudo têm hoje?"
)

// Assistente EdIA: faz RAG por palavra-chave sobre o material dos cursos.
// Regra de zero alucinação — sem uma fonte encontrada no material, a EdIA
// não responde, apenas informa que não encontrou a informação.
fun responder(pergunta: String): MensagemEdia {
    val texto = pergunta.lowercase()
    return when {
        texto.contains("bpf") || texto.contains("contamina") -> MensagemEdia(
            texto = "Contaminação cruzada é a transferência não intencional de um " +
                "contaminante (matéria-prima, produto, resíduo de limpeza ou material " +
                "biológico) de uma área, linha ou lote para outro. As causas mais comuns " +
                "em ambiente fabril são fluxo de pessoas e materiais mal planejado, " +
                "higienização incompleta entre lotes e uso de utensílios compartilhados " +
                "sem validação de limpeza. A RDC 658/2022 exige barreiras físicas, " +
                "procedimentos de troca de vestimenta e validação do processo de limpeza " +
                "para mitigar esse risco.",
            autor = AutorMensagem.EDIA,
            fonte = "Boas Práticas de Fabricação (BPF) > Módulo 1: Fundamentos de BPF > " +
                "Aula 2: Contaminação cruzada: causas e prevenção"
        )

        texto.contains("evento adverso") || texto.contains("notific") -> MensagemEdia(
            texto = "Para notificar um evento adverso, acesse o sistema VigiMed com sua " +
                "matrícula, registre o número do lote, a descrição do evento e a " +
                "gravidade percebida (leve, moderada ou grave). Eventos graves devem ser " +
                "reportados em até 24 horas. Depois do registro, a área de " +
                "Farmacovigilância avalia a causalidade e decide se é necessária uma " +
                "investigação de campo.",
            autor = AutorMensagem.EDIA,
            fonte = "Farmacovigilância na Prática > Módulo 2: Notificação de Eventos " +
                "Adversos > Aula 1: Como notificar um evento adverso no sistema VigiMed"
        )

        texto.contains("lgpd") -> MensagemEdia(
            texto = "Na indústria farmacêutica, são considerados dados sensíveis: " +
                "informações de saúde de pacientes e voluntários de estudos, dados de " +
                "eventos adversos relatados por profissionais de saúde, e dados " +
                "biométricos usados em controle de acesso a áreas fabris. Esses dados " +
                "exigem base legal específica para tratamento e medidas adicionais de " +
                "segurança, como criptografia e controle de acesso restrito.",
            autor = AutorMensagem.EDIA,
            fonte = "LGPD Aplicada à Indústria Farmacêutica > Módulo 1: Fundamentos da " +
                "LGPD > Aula 2: Dados sensíveis: informações de saúde e farmacovigilância"
        )

        texto.contains("valida") || texto.contains("protocolo") -> MensagemEdia(
            texto = "Um protocolo de validação descreve, antes da execução, o objetivo " +
                "do estudo, os critérios de aceitação, os equipamentos e instrumentos " +
                "envolvidos e o cronograma de execução. Ele costuma seguir a sequência " +
                "IQ (qualificação de instalação), OQ (qualificação de operação) e PQ " +
                "(qualificação de desempenho), cada etapa com seus próprios critérios de " +
                "aprovação antes de avançar para a seguinte.",
            autor = AutorMensagem.EDIA,
            fonte = "Validação de Processos Produtivos > Módulo 1: Fundamentos de " +
                "Validação > Aula 2: Protocolo de validação: estrutura e etapas"
        )

        texto.contains("progresso") -> MensagemEdia(
            texto = "Olhando seus cursos, você já concluiu Boas Práticas de Fabricação " +
                "(100%) e está com Compliance e Código de Conduta em 75%. " +
                "Farmacovigilância na Prática e LGPD Aplicada à Indústria Farmacêutica " +
                "estão pela metade, e Segurança do Trabalho em Ambiente Fabril ainda não " +
                "foi iniciado — esse é o que está com risco de evasão mais alto no " +
                "momento.",
            autor = AutorMensagem.EDIA,
            fonte = "Painel de progresso > Resumo dos seus cursos"
        )

        texto.contains("sala") -> MensagemEdia(
            texto = "Hoje às 19h00 tem a sala 'Tira-dúvidas: BPF na rotina do chão de " +
                "fábrica', mediada pela Fernanda Ristow, e ela já está quase lotada. Se " +
                "preferir outro tema, amanhã às 18h00 tem uma sala sobre notificação de " +
                "eventos adversos com o Dr. Ricardo Bonfim.",
            autor = AutorMensagem.EDIA,
            fonte = "Salas de Estudo > Agenda da semana"
        )

        else -> MensagemEdia(
            texto = "Não encontrei essa informação no material disponível. Para evitar " +
                "te dar uma resposta incorreta, prefiro não arriscar — tenta reformular " +
                "a pergunta com termos do curso ou fala com o mediador de uma Sala de " +
                "Estudo.",
            autor = AutorMensagem.EDIA,
            fonte = null
        )
    }
}
