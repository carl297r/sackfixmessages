package org.sackfix.fix44modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.modified.xml
  */
case class QuoteStatusRequestMessage(quoteStatusReqIDField:Option[QuoteStatusReqIDField]=None,
                                     quoteIDField:Option[QuoteIDField]=None,
                                     instrumentComponent:InstrumentComponent,
                                     financingDetailsComponent:Option[FinancingDetailsComponent]=None,
                                     noUnderlyingsField:Option[NoUnderlyingsField]=None,
                                     underlyingsGroups: Option[List[UnderlyingsGroup]]=None,
                                     noLegsField:Option[NoLegsField]=None,
                                     legsGroups: Option[List[LegsGroup]]=None,
                                     partiesComponent:Option[PartiesComponent]=None,
                                     accountField:Option[AccountField]=None,
                                     acctIDSourceField:Option[AcctIDSourceField]=None,
                                     accountTypeField:Option[AccountTypeField]=None,
                                     tradingSessionIDField:Option[TradingSessionIDField]=None,
                                     tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                                     subscriptionRequestTypeField:Option[SubscriptionRequestTypeField]=None) extends SfFixMessageBody("a")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUnderlyingsField.map(_.value).getOrElse(0) != underlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUnderlyingsField.TagId,noUnderlyingsField.map(_.value).getOrElse(0), underlyingsGroups.map(_.size).getOrElse(0))
  if (noLegsField.map(_.value).getOrElse(0) != legsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLegsField.TagId,noLegsField.map(_.value).getOrElse(0), legsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteStatusReqIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    financingDetailsComponent.foreach(fmt(b,_))
    noUnderlyingsField.foreach(fmt(b,_))
    underlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    noLegsField.foreach(fmt(b,_))
    legsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    subscriptionRequestTypeField.foreach(fmt(b,_))
    b
  }

}
     
object QuoteStatusRequestMessage extends SfFixMessageDecoder {
  val MsgType="a"
  val MsgName="QuoteStatusRequest"
             
  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentComponent.isMandatoryField(tagId) || FinancingDetailsComponent.isMandatoryField(tagId) || UnderlyingsGroup.isMandatoryField(tagId) || LegsGroup.isMandatoryField(tagId) || 
    PartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteStatusReqIDField.TagId, QuoteIDField.TagId, NoUnderlyingsField.TagId, NoLegsField.TagId, AccountField.TagId, 
    AcctIDSourceField.TagId, AccountTypeField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId, SubscriptionRequestTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentComponent.isOptionalField(tagId) || FinancingDetailsComponent.isOptionalField(tagId) || UnderlyingsGroup.isOptionalField(tagId) || LegsGroup.isOptionalField(tagId) || 
    PartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentComponent.isFieldOf(tagId) || FinancingDetailsComponent.isFieldOf(tagId) || UnderlyingsGroup.isFieldOf(tagId) || 
    LegsGroup.isFieldOf(tagId) || PartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUnderlyingsField.TagId, NoLegsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteStatusReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteStatusRequestMessage(myFields.get(QuoteStatusReqIDField.TagId).flatMap(f=>QuoteStatusReqIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        FinancingDetailsComponent.decode(flds, startPos),
        myFields.get(NoUnderlyingsField.TagId).flatMap(f=>NoUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoUnderlyingsField.TagId)) UnderlyingsGroup.decode(flds, nextTagPosLookup(NoUnderlyingsField.TagId)) else None,
        myFields.get(NoLegsField.TagId).flatMap(f=>NoLegsField.decode(f)),
        if (nextTagPosLookup.contains(NoLegsField.TagId)) LegsGroup.decode(flds, nextTagPosLookup(NoLegsField.TagId)) else None,
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        myFields.get(SubscriptionRequestTypeField.TagId).flatMap(f=>SubscriptionRequestTypeField.decode(f))))
    } else None
  }

    
}
     