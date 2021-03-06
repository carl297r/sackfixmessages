package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class SecurityXMLComponent(securityXMLLenField:Option[SecurityXMLLenField]=None,
                                securityXMLDataField:Option[SecurityXMLDataField]=None,
                                securityXMLSchemaField:Option[SecurityXMLSchemaField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    securityXMLLenField.foreach(fmt(b,_))
    securityXMLDataField.foreach(fmt(b,_))
    securityXMLSchemaField.foreach(fmt(b,_))
    b
  }

}
     
object SecurityXMLComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    SecurityXMLLenField.TagId, SecurityXMLDataField.TagId, SecurityXMLSchemaField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecurityXMLLenField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SecurityXMLComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SecurityXMLComponent(myFields.get(SecurityXMLLenField.TagId).flatMap(f=>SecurityXMLLenField.decode(f)),
        myFields.get(SecurityXMLDataField.TagId).flatMap(f=>SecurityXMLDataField.decode(f)),
        myFields.get(SecurityXMLSchemaField.TagId).flatMap(f=>SecurityXMLSchemaField.decode(f))))
    } else None
  }

    
}
     