package org.sackfix.fix44

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX44.xml
  */
case class LogonMessage(encryptMethodField:EncryptMethodField,
                        heartBtIntField:HeartBtIntField,
                        rawDataLengthField:Option[RawDataLengthField]=None,
                        rawDataField:Option[RawDataField]=None,
                        resetSeqNumFlagField:Option[ResetSeqNumFlagField]=None,
                        nextExpectedMsgSeqNumField:Option[NextExpectedMsgSeqNumField]=None,
                        maxMessageSizeField:Option[MaxMessageSizeField]=None,
                        noMsgTypesField:Option[NoMsgTypesField]=None,
                        msgTypesGroups: Option[List[MsgTypesGroup]]=None,
                        testMessageIndicatorField:Option[TestMessageIndicatorField]=None,
                        usernameField:Option[UsernameField]=None,
                        passwordField:Option[PasswordField]=None) extends SfFixMessageBody("A")  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMsgTypesField.map(_.value).getOrElse(0) != msgTypesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMsgTypesField.TagId,noMsgTypesField.map(_.value).getOrElse(0), msgTypesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,encryptMethodField)
    fmt(b,heartBtIntField)
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    resetSeqNumFlagField.foreach(fmt(b,_))
    nextExpectedMsgSeqNumField.foreach(fmt(b,_))
    maxMessageSizeField.foreach(fmt(b,_))
    noMsgTypesField.foreach(fmt(b,_))
    msgTypesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    testMessageIndicatorField.foreach(fmt(b,_))
    usernameField.foreach(fmt(b,_))
    passwordField.foreach(fmt(b,_))
    b
  }

}
     
object LogonMessage extends SfFixMessageDecoder {
  val MsgType="A"
  val MsgName="Logon"
             
  override val MandatoryFields = HashSet[Int](
    EncryptMethodField.TagId, HeartBtIntField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MsgTypesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    RawDataLengthField.TagId, RawDataField.TagId, ResetSeqNumFlagField.TagId, NextExpectedMsgSeqNumField.TagId, MaxMessageSizeField.TagId, 
    NoMsgTypesField.TagId, TestMessageIndicatorField.TagId, UsernameField.TagId, PasswordField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MsgTypesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MsgTypesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMsgTypesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==EncryptMethodField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(LogonMessage(EncryptMethodField.decode(myFields.get(EncryptMethodField.TagId)).get,
        HeartBtIntField.decode(myFields.get(HeartBtIntField.TagId)).get,
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f)),
        myFields.get(ResetSeqNumFlagField.TagId).flatMap(f=>ResetSeqNumFlagField.decode(f)),
        myFields.get(NextExpectedMsgSeqNumField.TagId).flatMap(f=>NextExpectedMsgSeqNumField.decode(f)),
        myFields.get(MaxMessageSizeField.TagId).flatMap(f=>MaxMessageSizeField.decode(f)),
        myFields.get(NoMsgTypesField.TagId).flatMap(f=>NoMsgTypesField.decode(f)),
        if (nextTagPosLookup.contains(NoMsgTypesField.TagId)) MsgTypesGroup.decode(flds, nextTagPosLookup(NoMsgTypesField.TagId)) else None,
        myFields.get(TestMessageIndicatorField.TagId).flatMap(f=>TestMessageIndicatorField.decode(f)),
        myFields.get(UsernameField.TagId).flatMap(f=>UsernameField.decode(f)),
        myFields.get(PasswordField.TagId).flatMap(f=>PasswordField.decode(f))))
    } else None
  }

    
}
     