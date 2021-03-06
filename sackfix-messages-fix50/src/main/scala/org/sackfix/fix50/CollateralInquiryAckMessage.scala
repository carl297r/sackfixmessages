package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class CollateralInquiryAckMessage(collInquiryIDField:CollInquiryIDField,
                                       collInquiryStatusField:CollInquiryStatusField,
                                       collInquiryResultField:Option[CollInquiryResultField]=None,
                                       collInqQualGrpComponent:Option[CollInqQualGrpComponent]=None,
                                       totNumReportsField:Option[TotNumReportsField]=None,
                                       partiesComponent:Option[PartiesComponent]=None,
                                       accountField:Option[AccountField]=None,
                                       accountTypeField:Option[AccountTypeField]=None,
                                       clOrdIDField:Option[ClOrdIDField]=None,
                                       orderIDField:Option[OrderIDField]=None,
                                       secondaryOrderIDField:Option[SecondaryOrderIDField]=None,
                                       secondaryClOrdIDField:Option[SecondaryClOrdIDField]=None,
                                       execCollGrpComponent:Option[ExecCollGrpComponent]=None,
                                       trdCollGrpComponent:Option[TrdCollGrpComponent]=None,
                                       instrumentComponent:Option[InstrumentComponent]=None,
                                       financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                       settlDateField:Option[SettlDateField]=None,
                                       quantityField:Option[QuantityField]=None,
                                       qtyTypeField:Option[QtyTypeField]=None,
                                       currencyField:Option[CurrencyField]=None,
                                       instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                       undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                       tradingSessionIDField:Option[TradingSessionIDField]=None,
                                       tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                       settlSessIDField:Option[SettlSessIDField]=None,
                                       settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                       clearingBusinessDateField:Option[ClearingBusinessDateField]=None,
                                       responseTransportTypeField:Option[ResponseTransportTypeField]=None,
                                       responseDestinationField:Option[ResponseDestinationField]=None,
                                       textField:Option[TextField]=None,
                                       encodedTextLenField:Option[EncodedTextLenField]=None,
                                       encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("BG")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,collInquiryIDField)
    fmt(b,collInquiryStatusField)
    collInquiryResultField.foreach(fmt(b,_))
    collInqQualGrpComponent.foreach(fmt(b,_))
    totNumReportsField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    orderIDField.foreach(fmt(b,_))
    secondaryOrderIDField.foreach(fmt(b,_))
    secondaryClOrdIDField.foreach(fmt(b,_))
    execCollGrpComponent.foreach(fmt(b,_))
    trdCollGrpComponent.foreach(fmt(b,_))
    instrumentComponent.foreach(fmt(b,_))
    financingDetailsComponent.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    quantityField.foreach(fmt(b,_))
    qtyTypeField.foreach(fmt(b,_))
    currencyField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    clearingBusinessDateField.foreach(fmt(b,_))
    responseTransportTypeField.foreach(fmt(b,_))
    responseDestinationField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object CollateralInquiryAckMessage extends SfFixMessageDecoder {
  val MsgType="BG"
  val MsgName="CollateralInquiryAck"
             
  override val MandatoryFields = HashSet[Int](
    CollInquiryIDField.TagId, CollInquiryStatusField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CollInqQualGrpComponent.isMandatoryField(tagId) || PartiesComponent.isMandatoryField(tagId) || ExecCollGrpComponent.isMandatoryField(tagId) || TrdCollGrpComponent.isMandatoryField(tagId) || 
    InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    CollInquiryResultField.TagId, TotNumReportsField.TagId, AccountField.TagId, AccountTypeField.TagId, ClOrdIDField.TagId, 
    OrderIDField.TagId, SecondaryOrderIDField.TagId, SecondaryClOrdIDField.TagId, SettlDateField.TagId, QuantityField.TagId, 
    QtyTypeField.TagId, CurrencyField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SettlSessIDField.TagId, 
    SettlSessSubIDField.TagId, ClearingBusinessDateField.TagId, ResponseTransportTypeField.TagId, ResponseDestinationField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CollInqQualGrpComponent.isOptionalField(tagId) || PartiesComponent.isOptionalField(tagId) || ExecCollGrpComponent.isOptionalField(tagId) || TrdCollGrpComponent.isOptionalField(tagId) || 
    InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CollInqQualGrpComponent.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId) || ExecCollGrpComponent.isFieldOf(tagId) || 
    TrdCollGrpComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==CollInquiryIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(CollateralInquiryAckMessage(CollInquiryIDField.decode(myFields.get(CollInquiryIDField.TagId)).get,
        CollInquiryStatusField.decode(myFields.get(CollInquiryStatusField.TagId)).get,
        myFields.get(CollInquiryResultField.TagId).flatMap(f=>CollInquiryResultField.decode(f)),
        CollInqQualGrpComponent.decode(flds, startPos),
        myFields.get(TotNumReportsField.TagId).flatMap(f=>TotNumReportsField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        myFields.get(OrderIDField.TagId).flatMap(f=>OrderIDField.decode(f)),
        myFields.get(SecondaryOrderIDField.TagId).flatMap(f=>SecondaryOrderIDField.decode(f)),
        myFields.get(SecondaryClOrdIDField.TagId).flatMap(f=>SecondaryClOrdIDField.decode(f)),
        ExecCollGrpComponent.decode(flds, startPos),
        TrdCollGrpComponent.decode(flds, startPos),
        InstrumentComponent.decode(flds, startPos),
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
        myFields.get(QuantityField.TagId).flatMap(f=>QuantityField.decode(f)),
        myFields.get(QtyTypeField.TagId).flatMap(f=>QtyTypeField.decode(f)),
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        myFields.get(ClearingBusinessDateField.TagId).flatMap(f=>ClearingBusinessDateField.decode(f)),
        myFields.get(ResponseTransportTypeField.TagId).flatMap(f=>ResponseTransportTypeField.decode(f)),
        myFields.get(ResponseDestinationField.TagId).flatMap(f=>ResponseDestinationField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     