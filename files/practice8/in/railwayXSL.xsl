<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output omit-xml-declaration="yes"/>

    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Employee id</th>
                            <th>Gender</th>
                            <th>LastName</th>
                            <th>FirstName</th>
                            <th>MiddleName</th>
                            <th>Role</th>
                            <th>Depot</th>
                            <th>Train</th>
                            <th>Composition</th>
                        </tr>
                    </thead>
                    <xsl:for-each select="Railway/Depot/Train/CompositionElement/Employee">
                        <tr>
                            <xsl:call-template name="PrintRailway"/>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template name="PrintRailway">
        <td>
            <xsl:value-of select="Id"/>
        </td>
        <td>
            <xsl:value-of select="Gender"/>
        </td>
        <td>
            <xsl:value-of select="LastName"/>
        </td>
        <td>
            <xsl:value-of select="FirstName"/>
        </td>
        <td>
            <xsl:value-of select="MiddleName"/>
        </td>
        <td>
            <xsl:value-of select="EmployeeRole"/>
        </td>
        <td>
            <xsl:value-of select="../../../DepotNumber"/>
        </td>
        <td>
            <xsl:value-of select="../../TrainName"/>
        </td>
        <td>
            <xsl:value-of select="../CompositionElementName"/>
        </td>
    </xsl:template>
</xsl:stylesheet>