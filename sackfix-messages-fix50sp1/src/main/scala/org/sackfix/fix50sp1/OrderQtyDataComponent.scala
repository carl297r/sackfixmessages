package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class OrderQtyDataComponent(orderQtyField:Option[OrderQtyField]=None,
                                 cashOrderQtyField:Option[CashOrderQtyField]=None,
                                 orderPercentField:Option[OrderPercentField]=None,
                                 roundingDirectionField:Option[RoundingDirectionField]=None,
                                 roundingModulusField:Option[RoundingModulusField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    orderQtyField.foreach(fmt(b,_))
    cashOrderQtyField.foreach(fmt(b,_))
    orderPercentField.foreach(fmt(b,_))
    roundingDirectionField.foreach(fmt(b,_))
    roundingModulusField.foreach(fmt(b,_))
    b
  }

}
     
object OrderQtyDataComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    OrderQtyField.TagId, CashOrderQtyField.TagId, OrderPercentField.TagId, RoundingDirectionField.TagId, RoundingModulusField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==OrderQtyField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[OrderQtyDataComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(OrderQtyDataComponent(myFields.get(OrderQtyField.TagId).flatMap(f=>OrderQtyField.decode(f)),
        myFields.get(CashOrderQtyField.TagId).flatMap(f=>CashOrderQtyField.decode(f)),
        myFields.get(OrderPercentField.TagId).flatMap(f=>OrderPercentField.decode(f)),
        myFields.get(RoundingDirectionField.TagId).flatMap(f=>RoundingDirectionField.decode(f)),
        myFields.get(RoundingModulusField.TagId).flatMap(f=>RoundingModulusField.decode(f))))
    } else None
  }

    
}
     