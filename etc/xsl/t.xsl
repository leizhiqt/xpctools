<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	version="1.0" exclude-result-prefixes="fo">
	
<xsl:template match="HBL">

<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

 <fo:layout-master-set>
    <fo:simple-page-master master-name="all"
	page-height="11.0in" page-width="8.5in"
       margin-top="0.2in" margin-bottom="0.2in" 
       margin-left="0.25in" margin-right="0.25in">
		<fo:region-body margin-top="0.25in" margin-bottom="0.25in"/>
    </fo:simple-page-master>
 </fo:layout-master-set>


 <fo:page-sequence master-reference="all">

    <fo:flow flow-name="xsl-region-body">
<!-- find a mechanism to handle the company specific logo and document name
-->
<!--
     <xsl:apply-templates select="companyName"/>     
     <xsl:apply-templates select="DocumentName"/>
-->

<fo:table>
      <fo:table-column column-width="4.0in"/>
      <fo:table-column column-width="4.0in"/>
<!--
 <fo:table-header>
  <fo:table-cell>
    <fo:block font-weight="bold">Car</fo:block>
  </fo:table-cell>
  <fo:table-cell>
    <fo:block font-weight="bold">Price</fo:block>
  </fo:table-cell>
</fo:table-header>
-->
      <fo:table-body>
	 	<fo:table-row>
		  <fo:table-cell text-align="right">
			<!--  TopRight sub-table -->
		     <fo:table>
		      <fo:table-column column-width="2.0in"/>
		      <fo:table-column column-width="2.0in"/>
		      <fo:table-body>
			 	<fo:table-row>
				  <fo:table-cell number-columns-spanned="2" text-align="left">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif" color="red">
						<xsl:value-of select="ShipperKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ShipperValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
			 	<fo:table-row>
				  <fo:table-cell  number-columns-spanned="2" text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ConsigneeKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ConsigneeValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
			 	<fo:table-row>
				  <fo:table-cell  number-columns-spanned="2" text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="NotifyPartyKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="NotifyPartyValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
			 	<fo:table-row>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="PreCarriageKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="PreCarriageValue"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="VesselKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="VesselValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
			 	<fo:table-row>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ReceiptPlaceKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ReceiptPlaceValue"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="POLPlaceKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="POLPlaceValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
			 	<fo:table-row>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="PODPlaceKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="PODPlaceValue"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="DeliveryPlaceKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="DeliveryPlaceValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
		      </fo:table-body>
		     </fo:table>
		  </fo:table-cell>
		  
		  <!-- Top Rigth sub-table -->
		  <fo:table-cell text-align="right">
		     <fo:table>
		      <fo:table-column column-width="2.0in"/>
		      <fo:table-column column-width="2.0in"/>
		      <fo:table-body>
			 	<fo:table-row>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="DocNoKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="DocNoValue"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="HouseBillNoKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="HouseBillNoValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
		
			 	<fo:table-row>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ExpRefNoKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ExpRefNoValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
			
			 	<fo:table-row>
				  <fo:table-cell  number-columns-spanned="2"  text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="DeliveryAgentKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="DeliveryAgentValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
		
			 	<fo:table-row>
				  <fo:table-cell  number-columns-spanned="2" text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="NotifyParty2Key"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="NotifyParty2Value"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
		
			 	<fo:table-row>
				  <fo:table-cell  number-columns-spanned="2" text-align="right">
					<xsl:apply-templates select="ContainerInfo"/>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ContainerInfoKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="ContainerInfoValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
				
			 	<fo:table-row>
				  <fo:table-cell  number-columns-spanned="2" text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="FinalDestKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="FinalDestValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
				
			 	<fo:table-row>
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="FreightStatusKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="FreightStatusValue"/>
					</fo:block>
				  </fo:table-cell>
		
				  <fo:table-cell text-align="right">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="NumOfOrgKey"/>
					</fo:block>
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						<xsl:value-of select="NumOfOrgValue"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
				
		      </fo:table-body>
		     </fo:table>
          </fo:table-cell>
		</fo:table-row>
	
	 	<fo:table-row>
		  <fo:table-cell text-align="right">
			<!--  middle subtable -->
		    <fo:table>
		      <fo:table-column column-width="1.0in"/>
		      <fo:table-column column-width="1.0in"/>
		      <fo:table-column column-width="3.0in"/>
		      <fo:table-column column-width="1.0in"/>
		      <fo:table-column column-width="1.0in"/>
		      <fo:table-body>
			 	<fo:table-row>
				  <fo:table-cell text-align="middle">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
					  <xsl:value-of select="Header1"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="middle">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
					  <xsl:value-of select="Header2"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="middle">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
					  <xsl:value-of select="Header3"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="middle">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
					  <xsl:value-of select="Header4"/>
					</fo:block>
				  </fo:table-cell>
				  <fo:table-cell text-align="middle">
					<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
					  <xsl:value-of select="Header5"/>
					</fo:block>
				  </fo:table-cell>
				</fo:table-row>
		
				<xsl:for-each select="FreightItem">
				 	<fo:table-row>
					  <fo:table-cell text-align="middle">
						<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						  <xsl:value-of select="FreightMark"/>
						</fo:block>
					  </fo:table-cell>
					  <fo:table-cell text-align="middle">
						<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						  <xsl:value-of select="FreightNumOfPKG"/>
						</fo:block>
					  </fo:table-cell>
					  <fo:table-cell text-align="middle">
						<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						  <xsl:value-of select="FreightDesc"/>
						</fo:block>
					  </fo:table-cell>
					  <fo:table-cell text-align="middle">
						<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						  <xsl:value-of select="FreightGross"/>
						</fo:block>
					  </fo:table-cell>
					  <fo:table-cell text-align="middle">
						<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						  <xsl:value-of select="FreightMeasure"/>
						</fo:block>
					  </fo:table-cell>
					</fo:table-row>
		      	</xsl:for-each>
				<xsl:for-each select="FreightMessage">
				 	<fo:table-row>
					  <fo:table-cell  number-columns-spanned="5" text-align="right">
						<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
						  <xsl:value-of select="."/>
						</fo:block>
					  </fo:table-cell>
					</fo:table-row>
		      	</xsl:for-each>
		      </fo:table-body>
		     </fo:table>
		  </fo:table-cell>
		</fo:table-row>

	 	<fo:table-row>
		  <fo:table-cell  number-columns-spanned="2" text-align="right">
			<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
				<xsl:value-of select="ValueDeclKey"/>: <xsl:value-of select="ValueDeclValue"/>
			</fo:block>
		  </fo:table-cell>
		</fo:table-row>

	 	<fo:table-row>
		  <fo:table-cell  number-columns-spanned="2"  text-align="right">
			<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
				<xsl:value-of select="WordPacksKey"/>: <xsl:value-of select="WordPacksValue"/>
			</fo:block>
		  </fo:table-cell>
		</fo:table-row>

	 	<fo:table-row>
		  <fo:table-cell  number-columns-spanned="2" text-align="right">
			<!--  bottom freight subtable -->
		    <fo:table>
		      <fo:table-column column-width="2.7in"/>
		      <fo:table-column column-width="2.6in"/>
		      <fo:table-column column-width="2.6in"/>
		      <fo:table-body>
			 	<fo:table-row>
				  <fo:table-cell text-align="middle">
					  <xsl:value-of select="FreightHeader"/>
				  </fo:table-cell>
				  <fo:table-cell text-align="middle">
					  <xsl:value-of select="PrepaidHeader"/>
				  </fo:table-cell>
				  <fo:table-cell text-align="middle">
					  <xsl:value-of select="CollectHeader"/>
				  </fo:table-cell>
				</fo:table-row>
		
			 	<fo:table-row>
				  <fo:table-cell text-align="left">
					  <xsl:value-of select="Freight"/>
				  </fo:table-cell>
				  <fo:table-cell text-align="left">
					  <xsl:value-of select="Prepaid"/>
				  </fo:table-cell>
				  <fo:table-cell text-align="left">
					  <xsl:value-of select="Collect"/>
				  </fo:table-cell>
				</fo:table-row>

			 	<fo:table-row>
				  <fo:table-cell text-align="left">
					  <xsl:value-of select="AmountDueKey"/>
				  </fo:table-cell>
				  <fo:table-cell text-align="left">
					  <xsl:value-of select="PrepaidDue"/>
				  </fo:table-cell>
				  <fo:table-cell text-align="left">
					  <xsl:value-of select="CollectDue"/>
				  </fo:table-cell>
				</fo:table-row>
		      </fo:table-body>
		     </fo:table>
		  </fo:table-cell>
		  <fo:table-cell   number-columns-spanned="2" text-align="right">
			<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
				<xsl:value-of select="IssueKey"/>: <xsl:value-of select="IssuePlaceValue"/> <xsl:value-of select="IssueDateValue"/>
			</fo:block>
			<fo:block text-align="start" font-size="8pt" font-family="sans-serif">
				<xsl:value-of select="SignKey"/>: 
			</fo:block>
		  </fo:table-cell>
		</fo:table-row>
      
           </fo:table-body>
       </fo:table>

<!--  will handle footer later
     <xsl:apply-templates select="footer"/>
 -->

      <fo:table>
         <fo:table-column column-width="4in"/>
         <fo:table-column column-width="4in"/>
    <fo:table-header>
     <fo:table-row>
        <fo:table-cell>
          <fo:block font-weight="bold" color="#ff00ff" text-indent="0.5in">Car</fo:block>
        </fo:table-cell>
        <fo:table-cell>
          <fo:block font-weight="bold" color="#9acd32" text-indent="0.5in">Price</fo:block>
         </fo:table-cell>
      </fo:table-row>
     </fo:table-header> 
        <fo:table-body> 
          <fo:table-row>
    <fo:table-cell>
      <fo:block font-size="12pt" text-indent="0.5in">Volvo</fo:block>
    </fo:table-cell>
    <fo:table-cell>
      <fo:block font-size="12pt" text-indent="0.5in">$50000</fo:block>

    </fo:table-cell>
  </fo:table-row>
  <fo:table-row>
    <fo:table-cell>

      <fo:block font-size="12pt" text-indent="0.5in" space-before="5mm" space-after="5mm"
font-family="verdana">SAAB</fo:block>
<fo:block>
  LL
<fo:inline ID="A">LLL</fo:inline>
<fo:bidi-override direction="rtl">
   <fo:inline ID="A+">RRR</fo:inline>
   RR
</fo:bidi-override>

</fo:block>

    </fo:table-cell>
    <fo:table-cell>
      <fo:block font-size="12pt" text-indent="0.5in">$48000</fo:block>

<fo:list-block>

<fo:list-item>
 <fo:list-item-label>
   <fo:block>*</fo:block>
 </fo:list-item-label>
 <fo:list-item-body>
   <fo:block text-indent="0.1in"  text-align="center">Volvo</fo:block>
 </fo:list-item-body>
</fo:list-item>

<fo:list-item  color="green">
 <fo:list-item-label>
   <fo:block>*</fo:block>
 </fo:list-item-label>
 <fo:list-item-body background-color="red">
   <fo:block background-color="inherited-property-value(color)">SAAB</fo:block>
 </fo:list-item-body>
</fo:list-item>

</fo:list-block>
<fo:block text-indent="0pc" space-after="7pt"
  space-before.minimum="6pt" space-before.optimum="8pt"
  space-before.maximum="10pt">Section one's first paragraph.
</fo:block>

    </fo:table-cell>
  </fo:table-row>			 
	</fo:table-body>		
       </fo:table>      
     </fo:flow>
</fo:page-sequence>
</fo:root>
</xsl:template>
</xsl:stylesheet>		  
  


 
