package org.sackfix.fix42

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX42.xml
  */
case class DontKnowTradeMessage(orderIDField:OrderIDField,
                                execIDField:ExecIDField,
                                dKReasonField:DKReasonField,
                                symbolField:SymbolField,
                                symbolSfxField:Option[SymbolSfxField]=None,
                                securityIDField:Option[SecurityIDField]=None,
                                iDSourceField:Option[IDSourceField]=None,
                                securityTypeField:Option[SecurityTypeField]=None,
                                maturityMonthYearField:Option[MaturityMonthYearField]=None,
                                maturityDayField:Option[MaturityDayField]=None,
                                putOrCallField:Option[PutOrCallField]=None,
                                strikePriceField:Option[StrikePriceField]=None,
                                optAttributeField:Option[OptAttributeField]=None,
                                contractMultiplierField:Option[ContractMultiplierField]=None,
                                couponRateField:Option[CouponRateField]=None,
                                securityExchangeField:Option[SecurityExchangeField]=None,
                                issuerField:Option[IssuerField]=None,
                                encodedIssuerLenField:Option[EncodedIssuerLenField]=None,
                                encodedIssuerField:Option[EncodedIssuerField]=None,
                                securityDescField:Option[SecurityDescField]=None,
                                encodedSecurityDescLenField:Option[EncodedSecurityDescLenField]=None,
                                encodedSecurityDescField:Option[EncodedSecurityDescField]=None,
                                sideField:SideField,
                                orderQtyField:Option[OrderQtyField]=None,
                                cashOrderQtyField:Option[CashOrderQtyField]=None,
                                lastSharesField:Option[LastSharesField]=None,
                                lastPxField:Option[LastPxField]=None,
                                textField:Option[TextField]=None,
                                encodedTextLenField:Option[EncodedTextLenField]=None,
                                encodedTextField:Option[EncodedTextField]=None) extends SfFixMessageBody("Q")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,orderIDField)
    fmt(b,execIDField)
    fmt(b,dKReasonField)
    fmt(b,symbolField)
    symbolSfxField.foreach(fmt(b,_))
    securityIDField.foreach(fmt(b,_))
    iDSourceField.foreach(fmt(b,_))
    securityTypeField.foreach(fmt(b,_))
    maturityMonthYearField.foreach(fmt(b,_))
    maturityDayField.foreach(fmt(b,_))
    putOrCallField.foreach(fmt(b,_))
    strikePriceField.foreach(fmt(b,_))
    optAttributeField.foreach(fmt(b,_))
    contractMultiplierField.foreach(fmt(b,_))
    couponRateField.foreach(fmt(b,_))
    securityExchangeField.foreach(fmt(b,_))
    issuerField.foreach(fmt(b,_))
    encodedIssuerLenField.foreach(fmt(b,_))
    encodedIssuerField.foreach(fmt(b,_))
    securityDescField.foreach(fmt(b,_))
    encodedSecurityDescLenField.foreach(fmt(b,_))
    encodedSecurityDescField.foreach(fmt(b,_))
    fmt(b,sideField)
    orderQtyField.foreach(fmt(b,_))
    cashOrderQtyField.foreach(fmt(b,_))
    lastSharesField.foreach(fmt(b,_))
    lastPxField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object DontKnowTradeMessage extends SfFixMessageDecoder {
  val MsgType="Q"
  val MsgName="DontKnowTrade"
             
  override val MandatoryFields = HashSet[Int](
    OrderIDField.TagId, ExecIDField.TagId, DKReasonField.TagId, SymbolField.TagId, SideField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    SymbolSfxField.TagId, SecurityIDField.TagId, IDSourceField.TagId, SecurityTypeField.TagId, MaturityMonthYearField.TagId, 
    MaturityDayField.TagId, PutOrCallField.TagId, StrikePriceField.TagId, OptAttributeField.TagId, ContractMultiplierField.TagId, 
    CouponRateField.TagId, SecurityExchangeField.TagId, IssuerField.TagId, EncodedIssuerLenField.TagId, EncodedIssuerField.TagId, 
    SecurityDescField.TagId, EncodedSecurityDescLenField.TagId, EncodedSecurityDescField.TagId, OrderQtyField.TagId, CashOrderQtyField.TagId, 
    LastSharesField.TagId, LastPxField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(DontKnowTradeMessage(OrderIDField.decode(myFields.get(OrderIDField.TagId)).get,
        ExecIDField.decode(myFields.get(ExecIDField.TagId)).get,
        DKReasonField.decode(myFields.get(DKReasonField.TagId)).get,
        SymbolField.decode(myFields.get(SymbolField.TagId)).get,
        myFields.get(SymbolSfxField.TagId).flatMap(f=>SymbolSfxField.decode(f)),
        myFields.get(SecurityIDField.TagId).flatMap(f=>SecurityIDField.decode(f)),
        myFields.get(IDSourceField.TagId).flatMap(f=>IDSourceField.decode(f)),
        myFields.get(SecurityTypeField.TagId).flatMap(f=>SecurityTypeField.decode(f)),
        myFields.get(MaturityMonthYearField.TagId).flatMap(f=>MaturityMonthYearField.decode(f)),
        myFields.get(MaturityDayField.TagId).flatMap(f=>MaturityDayField.decode(f)),
        myFields.get(PutOrCallField.TagId).flatMap(f=>PutOrCallField.decode(f)),
        myFields.get(StrikePriceField.TagId).flatMap(f=>StrikePriceField.decode(f)),
        myFields.get(OptAttributeField.TagId).flatMap(f=>OptAttributeField.decode(f)),
        myFields.get(ContractMultiplierField.TagId).flatMap(f=>ContractMultiplierField.decode(f)),
        myFields.get(CouponRateField.TagId).flatMap(f=>CouponRateField.decode(f)),
        myFields.get(SecurityExchangeField.TagId).flatMap(f=>SecurityExchangeField.decode(f)),
        myFields.get(IssuerField.TagId).flatMap(f=>IssuerField.decode(f)),
        myFields.get(EncodedIssuerLenField.TagId).flatMap(f=>EncodedIssuerLenField.decode(f)),
        myFields.get(EncodedIssuerField.TagId).flatMap(f=>EncodedIssuerField.decode(f)),
        myFields.get(SecurityDescField.TagId).flatMap(f=>SecurityDescField.decode(f)),
        myFields.get(EncodedSecurityDescLenField.TagId).flatMap(f=>EncodedSecurityDescLenField.decode(f)),
        myFields.get(EncodedSecurityDescField.TagId).flatMap(f=>EncodedSecurityDescField.decode(f)),
        SideField.decode(myFields.get(SideField.TagId)).get,
        myFields.get(OrderQtyField.TagId).flatMap(f=>OrderQtyField.decode(f)),
        myFields.get(CashOrderQtyField.TagId).flatMap(f=>CashOrderQtyField.decode(f)),
        myFields.get(LastSharesField.TagId).flatMap(f=>LastSharesField.decode(f)),
        myFields.get(LastPxField.TagId).flatMap(f=>LastPxField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f))))
    } else None
  }

    
}
     