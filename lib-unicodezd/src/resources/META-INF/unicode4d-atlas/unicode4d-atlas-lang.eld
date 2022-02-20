<?xml version="1.0" encoding="UTF-8"?>
<root:module xmlns:root="http://eld.x4o.org/xml/ns/eld-root"
	xmlns:eld="http://eld.x4o.org/xml/ns/eld-lang"
	xmlns:conv="http://eld.x4o.org/xml/ns/eld-conv"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://eld.x4o.org/xml/ns/eld-root http://eld.x4o.org/xml/ns/eld-root-1.0.xsd"
	providerHost="unicode4d-atlas.x4o.distributedrebirth.love" providerName="FontAtlas Glyph Store"
	id="unicode4d-atlas-module">

	<eld:classBindingHandler id="FontAtlas-FontAtlasStore"
		parentClass="love.distributedrebirth.unicode4d.atlas.FontAtlas"
		childClass="love.distributedrebirth.unicode4d.atlas.FontAtlasStore"
		addMethod="addStore" getMethod="getStores" />
	<eld:classBindingHandler id="FontAtlasStore-FontAtlasStoreGlyph"
		parentClass="love.distributedrebirth.unicode4d.atlas.FontAtlasStore"
		childClass="love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph"
		addMethod="addGlyph" getMethod="getGlyphs" />
	
	<eld:namespace
		uri="http://unicode4d-atlas.x4o.distributedrebirth.love/xml/ns/unicode4d-atlas-root"
		schemaUri="http://unicode4d-atlas.x4o.distributedrebirth.love/xml/ns/unicode4d-atlas-root-1.0.xsd"
		schemaResource="unicode4d-atlas-root-1.0.xsd" schemaPrefix="r"
		description="Namespace to have single root."
		name="UnicodePlane Root Namespace" languageRoot="true" id="r">
		<eld:element tag="a"
			objectClass="love.distributedrebirth.unicode4d.atlas.FontAtlas"/>
	</eld:namespace>

	<eld:namespace
		uri="http://unicode4d-atlas.x4o.distributedrebirth.love/xml/ns/unicode4d-atlas-lang"
		schemaUri="http://unicode4d-atlas.x4o.distributedrebirth.love/xml/ns/unicode4d-atlas-lang-1.0.xsd"
		schemaResource="unicode4d-atlas-lang-1.0.xsd" schemaPrefix="l"
		description="Namespace to store glyphs."
		name="UnicodePlane Language Namespace" id="l">
		<eld:element tag="s"
			objectClass="love.distributedrebirth.unicode4d.atlas.FontAtlasStore" />
		<eld:element tag="g"
			objectClass="love.distributedrebirth.unicode4d.atlas.FontAtlasStoreGlyph" />
	</eld:namespace>
</root:module>