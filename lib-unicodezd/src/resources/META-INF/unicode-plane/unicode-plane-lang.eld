<?xml version="1.0" encoding="UTF-8"?>
<root:module xmlns:root="http://eld.x4o.org/xml/ns/eld-root"
	xmlns:eld="http://eld.x4o.org/xml/ns/eld-lang"
	xmlns:conv="http://eld.x4o.org/xml/ns/eld-conv"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://eld.x4o.org/xml/ns/eld-root http://eld.x4o.org/xml/ns/eld-root-1.0.xsd"
	providerHost="unicode-plane.x4o.distributedrebirth.love" providerName="UnicodePlane Encryption"
	id="unicode-plane-module">

	<eld:classBindingHandler id="UnicodePlane-UnicodePlaneBase"
		parentClass="love.distributedrebirth.unicode4d.base.UnicodePlane"
		childClass="love.distributedrebirth.unicode4d.base.UnicodePlaneBase"
		addMethod="addPlane" getMethod="getPlanes" />
	<eld:classBindingHandler id="UnicodePlaneBase-UnicodePlaneBaseGlyph"
		parentClass="love.distributedrebirth.unicode4d.base.UnicodePlaneBase"
		childClass="love.distributedrebirth.unicode4d.base.UnicodePlaneBaseGlyph"
		addMethod="addBaseGlyph" getMethod="getBaseGlyphs" />
	
	<eld:namespace
		uri="http://unicode-plane.x4o.distributedrebirth.love/xml/ns/unicode-plane-root"
		schemaUri="http://unicode-plane.x4o.distributedrebirth.love/xml/ns/unicode-plane-root-1.0.xsd"
		schemaResource="unicode-plane-root-1.0.xsd" schemaPrefix="root"
		description="Root namespace to have nice namespaceing."
		name="UnicodePlane Root Namespace" languageRoot="true" id="root">
		<eld:element tag="unicode"
			objectClass="love.distributedrebirth.unicode4d.base.UnicodePlane"/>
	</eld:namespace>

	<eld:namespace
		uri="http://unicode-plane.x4o.distributedrebirth.love/xml/ns/unicode-plane-lang"
		schemaUri="http://unicode-plane.x4o.distributedrebirth.love/xml/ns/unicode-plane-lang-1.0.xsd"
		schemaResource="unicode-plane-lang-1.0.xsd" schemaPrefix="l"
		description="Language namespace to store unicode planes."
		name="UnicodePlane Language Namespace" id="l">
		<eld:element tag="plane"
			objectClass="love.distributedrebirth.unicode4d.base.UnicodePlaneBase" />
		<eld:element tag="glyph"
			objectClass="love.distributedrebirth.unicode4d.base.UnicodePlaneBaseGlyph" />
	</eld:namespace>
</root:module>