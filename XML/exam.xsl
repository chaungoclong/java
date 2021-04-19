<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<table border="1">
					<caption>HELLO</caption>
					<thead>
						<th>Name</th>
						<th>Price</th>
						<th>Description</th>
						<th>Calories</th>
					</thead>
					
					<tbody>
						<xsl:for-each select="Menu/Food">
							<tr>
								<td><xsl:value-of select="Name"/></td>
								<td><xsl:value-of select="Price"/></td>
								<td><xsl:value-of select="Description"/></td>
								<td><xsl:value-of select="Calories"/></td>
							</tr>
						</xsl:for-each>
					</tbody>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>