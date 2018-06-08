<?xml version="1.0" encoding="UTF-8"?>

<xs:stylesheet version="1.0"
	xmlns:xs="http://www.w3.org/1999/XSL/Transform">

	<xs:template match="/">
		<xs:apply-templates select="*" />
	</xs:template>
	<xs:template match="@* | node()">
		<xs:copy>
			<xs:apply-templates select="@* | node()" />
		</xs:copy>
	</xs:template>

	<!-- Eliminate the following -->
	<xs:template match="Language" />

</xs:stylesheet>