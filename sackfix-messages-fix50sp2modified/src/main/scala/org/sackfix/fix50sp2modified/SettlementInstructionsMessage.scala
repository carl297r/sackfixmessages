package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class SettlementInstructionsMessage(settlInstMsgIDField:SettlInstMsgIDField,
                                         settlInstReqIDField:Option[SettlInstReqIDField]=None,
                                         settlInstModeField:SettlInstModeField,
                                         settlInstReqRejCodeField:Option[SettlInstReqRejCodeField]=None,
                                         textField:Option[TextField]=None,
                                         encodedTextLenField:Option[EncodedTextLenField]=None,
                                         encodedTextField:Option[EncodedTextField]=None,
                                         clOrdIDField:Option[ClOrdIDField]=None,
                                         transactTimeField:TransactTimeField,
                                         settlInstGrpComponent:Option[SettlInstGrpComponent]=None) extends SfFixMessageBody("T")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,settlInstMsgIDField)
    settlInstReqIDField.foreach(fmt(b,_))
    fmt(b,settlInstModeField)
    settlInstReqRejCodeField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    clOrdIDField.foreach(fmt(b,_))
    fmt(b,transactTimeField)
    settlInstGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object SettlementInstructionsMessage extends SfFixMessageDecoder {
  val MsgType="T"
  val MsgName="SettlementInstructions"
             
  override val MandatoryFields = HashSet[Int](
    SettlInstMsgIDField.TagId, SettlInstModeField.TagId, TransactTimeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SettlInstGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    SettlInstReqIDField.TagId, SettlInstReqRejCodeField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId, 
    ClOrdIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SettlInstGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SettlInstGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SettlInstMsgIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(SettlementInstructionsMessage(SettlInstMsgIDField.decode(myFields.get(SettlInstMsgIDField.TagId)).get,
        myFields.get(SettlInstReqIDField.TagId).flatMap(f=>SettlInstReqIDField.decode(f)),
        SettlInstModeField.decode(myFields.get(SettlInstModeField.TagId)).get,
        myFields.get(SettlInstReqRejCodeField.TagId).flatMap(f=>SettlInstReqRejCodeField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(ClOrdIDField.TagId).flatMap(f=>ClOrdIDField.decode(f)),
        TransactTimeField.decode(myFields.get(TransactTimeField.TagId)).get,
        SettlInstGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     