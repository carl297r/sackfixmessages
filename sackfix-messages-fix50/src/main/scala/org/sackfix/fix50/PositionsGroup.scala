package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class PositionsGroup(posTypeField:Option[PosTypeField]=None,
                          longQtyField:Option[LongQtyField]=None,
                          shortQtyField:Option[ShortQtyField]=None,
                          posQtyStatusField:Option[PosQtyStatusField]=None,
                          nestedPartiesComponent:Option[NestedPartiesComponent]=None,
                          quantityDateField:Option[QuantityDateField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    posTypeField.foreach(fmt(b,_))
    longQtyField.foreach(fmt(b,_))
    shortQtyField.foreach(fmt(b,_))
    posQtyStatusField.foreach(fmt(b,_))
    nestedPartiesComponent.foreach(fmt(b,_))
    quantityDateField.foreach(fmt(b,_))
    b
  }

}
     
object PositionsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NestedPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PosTypeField.TagId, LongQtyField.TagId, ShortQtyField.TagId, PosQtyStatusField.TagId, QuantityDateField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NestedPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NestedPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PosTypeField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[PositionsGroup]=ArrayBuffer.empty[PositionsGroup]):Option[List[PositionsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[PositionsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[PositionsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(PositionsGroup(myFields.get(PosTypeField.TagId).flatMap(f=>PosTypeField.decode(f)),
          myFields.get(LongQtyField.TagId).flatMap(f=>LongQtyField.decode(f)),
          myFields.get(ShortQtyField.TagId).flatMap(f=>ShortQtyField.decode(f)),
          myFields.get(PosQtyStatusField.TagId).flatMap(f=>PosQtyStatusField.decode(f)),
          NestedPartiesComponent.decode(flds, startPos),
          myFields.get(QuantityDateField.TagId).flatMap(f=>QuantityDateField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     