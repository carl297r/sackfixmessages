package org.sackfix.fix43

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX43.xml
  */
case class LegsGroup(instrumentLegComponent:Option[InstrumentLegComponent]=None,
                     legPositionEffectField:Option[LegPositionEffectField]=None,
                     legCoveredOrUncoveredField:Option[LegCoveredOrUncoveredField]=None,
                     nestedPartiesComponent:Option[NestedPartiesComponent]=None,
                     legRefIDField:Option[LegRefIDField]=None,
                     legPriceField:Option[LegPriceField]=None,
                     legSettlmntTypField:Option[LegSettlmntTypField]=None,
                     legFutSettDateField:Option[LegFutSettDateField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    instrumentLegComponent.foreach(fmt(b,_))
    legPositionEffectField.foreach(fmt(b,_))
    legCoveredOrUncoveredField.foreach(fmt(b,_))
    nestedPartiesComponent.foreach(fmt(b,_))
    legRefIDField.foreach(fmt(b,_))
    legPriceField.foreach(fmt(b,_))
    legSettlmntTypField.foreach(fmt(b,_))
    legFutSettDateField.foreach(fmt(b,_))
    b
  }

}
     
object LegsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    InstrumentLegComponent.isMandatoryField(tagId) || NestedPartiesComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    LegPositionEffectField.TagId, LegCoveredOrUncoveredField.TagId, LegRefIDField.TagId, LegPriceField.TagId, LegSettlmntTypField.TagId, 
    LegFutSettDateField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    InstrumentLegComponent.isOptionalField(tagId) || NestedPartiesComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    InstrumentLegComponent.isFieldOf(tagId) || NestedPartiesComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = InstrumentLegComponent.isFirstField(tagId) 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[LegsGroup]=ArrayBuffer.empty[LegsGroup]):Option[List[LegsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[LegsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[LegsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(LegsGroup(InstrumentLegComponent.decode(flds, startPos),
          myFields.get(LegPositionEffectField.TagId).flatMap(f=>LegPositionEffectField.decode(f)),
          myFields.get(LegCoveredOrUncoveredField.TagId).flatMap(f=>LegCoveredOrUncoveredField.decode(f)),
          NestedPartiesComponent.decode(flds, startPos),
          myFields.get(LegRefIDField.TagId).flatMap(f=>LegRefIDField.decode(f)),
          myFields.get(LegPriceField.TagId).flatMap(f=>LegPriceField.decode(f)),
          myFields.get(LegSettlmntTypField.TagId).flatMap(f=>LegSettlmntTypField.decode(f)),
          myFields.get(LegFutSettDateField.TagId).flatMap(f=>LegFutSettDateField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     