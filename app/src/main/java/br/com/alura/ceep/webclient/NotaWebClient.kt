package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota
import br.com.alura.ceep.webclient.model.NotaRequisicao

private const val TAG = "NotaWebClient"

class NotaWebClient() {

    private val notaService = RetrofitInicializador().notaService

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val notasResposta = notaService.buscaTodas()
            notasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            Log.e(TAG, "buscaTodas: ${e.localizedMessage}", e)
            null
        }
    }

    suspend fun salva(nota: Nota) {
        try {
            val resposta = notaService.salva(nota.id, NotaRequisicao(
                titulo = nota.titulo,
                descricao = nota.descricao,
                imagem = nota.imagem
            ))
            if (resposta.isSuccessful) {
                Log.i(TAG, "salva: nota salva com sucesso")
            } else {
                Log.e(TAG, "salva: falha ao tentar salvar -> ${resposta.errorBody()}")
            }
        } catch (e: Exception) {
            Log.e(TAG, "salva: falha ao tentar salvar -> ${e.localizedMessage}", e)
        }
    }
}