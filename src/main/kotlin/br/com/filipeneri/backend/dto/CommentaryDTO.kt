package br.com.filipeneri.backend.dto

data class FinishOrderDTO(
        var orderId :Long,
        var commentary:String,
        var totalOrder:Double
)
