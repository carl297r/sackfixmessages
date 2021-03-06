package org.sackfix.fix42

import org.sackfix.common.validated.fields.SfFixMessageDecoder

/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
object SfMessageFactory {
  def getMessage(msgType:String):Option[SfFixMessageDecoder] = msgType match {
    case "0" => Some(HeartbeatMessage)
    case "A" => Some(LogonMessage)
    case "1" => Some(TestRequestMessage)
    case "2" => Some(ResendRequestMessage)
    case "3" => Some(RejectMessage)
    case "4" => Some(SequenceResetMessage)
    case "5" => Some(LogoutMessage)
    case "7" => Some(AdvertisementMessage)
    case "6" => Some(IndicationofInterestMessage)
    case "B" => Some(NewsMessage)
    case "C" => Some(EmailMessage)
    case "R" => Some(QuoteRequestMessage)
    case "S" => Some(QuoteMessage)
    case "i" => Some(MassQuoteMessage)
    case "Z" => Some(QuoteCancelMessage)
    case "a" => Some(QuoteStatusRequestMessage)
    case "b" => Some(QuoteAcknowledgementMessage)
    case "V" => Some(MarketDataRequestMessage)
    case "W" => Some(MarketDataSnapshotFullRefreshMessage)
    case "X" => Some(MarketDataIncrementalRefreshMessage)
    case "Y" => Some(MarketDataRequestRejectMessage)
    case "c" => Some(SecurityDefinitionRequestMessage)
    case "d" => Some(SecurityDefinitionMessage)
    case "e" => Some(SecurityStatusRequestMessage)
    case "f" => Some(SecurityStatusMessage)
    case "g" => Some(TradingSessionStatusRequestMessage)
    case "h" => Some(TradingSessionStatusMessage)
    case "D" => Some(NewOrderSingleMessage)
    case "8" => Some(ExecutionReportMessage)
    case "Q" => Some(DontKnowTradeMessage)
    case "G" => Some(OrderCancelReplaceRequestMessage)
    case "F" => Some(OrderCancelRequestMessage)
    case "9" => Some(OrderCancelRejectMessage)
    case "H" => Some(OrderStatusRequestMessage)
    case "J" => Some(AllocationMessage)
    case "P" => Some(AllocationACKMessage)
    case "T" => Some(SettlementInstructionsMessage)
    case "k" => Some(BidRequestMessage)
    case "l" => Some(BidResponseMessage)
    case "E" => Some(NewOrderListMessage)
    case "m" => Some(ListStrikePriceMessage)
    case "N" => Some(ListStatusMessage)
    case "L" => Some(ListExecuteMessage)
    case "K" => Some(ListCancelRequestMessage)
    case "M" => Some(ListStatusRequestMessage)
    case "j" => Some(BusinessMessageRejectMessage)
    case _ => None
  }
}
