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
case class MarketDataFeedTypesComponent(noMDFeedTypesField:Option[NoMDFeedTypesField]=None,
                                        mDFeedTypesGroups: Option[List[MDFeedTypesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noMDFeedTypesField.map(_.value).getOrElse(0) != mDFeedTypesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoMDFeedTypesField.TagId,noMDFeedTypesField.map(_.value).getOrElse(0), mDFeedTypesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noMDFeedTypesField.foreach(fmt(b,_))
    mDFeedTypesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object MarketDataFeedTypesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    MDFeedTypesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoMDFeedTypesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    MDFeedTypesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    MDFeedTypesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoMDFeedTypesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = MDFeedTypesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[MarketDataFeedTypesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(MarketDataFeedTypesComponent(myFields.get(NoMDFeedTypesField.TagId).flatMap(f=>NoMDFeedTypesField.decode(f)),
        if (nextTagPosLookup.contains(NoMDFeedTypesField.TagId)) MDFeedTypesGroup.decode(flds, nextTagPosLookup(NoMDFeedTypesField.TagId)) else None))
    } else None
  }

    
}
     