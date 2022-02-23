<?xml version="1.0" encoding="UTF-8"?>
<root:module xmlns:root="http://eld.x4o.org/xml/ns/eld-root"
	xmlns:eld="http://eld.x4o.org/xml/ns/eld-lang"
	xmlns:conv="http://eld.x4o.org/xml/ns/eld-conv"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://eld.x4o.org/xml/ns/eld-root http://eld.x4o.org/xml/ns/eld-root-1.0.xsd"
	providerHost="warp-hash.x4o.distributedrebirth.love" providerName="WarpHashᵐᵉ"
	id="warp-hash-module">

	<eld:classBindingHandler id="WaterShot-WaterSoftHash"
		parentClass="love.distributedrebirth.warpme.hash.WaterShot"
		childClass="love.distributedrebirth.warpme.hash.WaterSoftHash"
		addMethod="addSoftHash" getMethod="getSoftHashes" />
	
	<eld:namespace
		uri="http://wrap-core.x4o.distributedrebirth.love/xml/ns/warp-hash-root"
		schemaUri="http://warp-hash.x4o.distributedrebirth.love/xml/ns/warp-hash-root-1.0.xsd"
		schemaResource="warp-hash-root-1.0.xsd" schemaPrefix="root"
		description="Root namespace to have nice namespaceing."
		name="WarpHash Root Namespace" languageRoot="true" id="root">
		<eld:element tag="shot"
			objectClass="love.distributedrebirth.warpme.hash.WaterShot"/>
	</eld:namespace>

	<eld:namespace
		uri="http://warp-hash.x4o.distributedrebirth.love/xml/ns/warp-hash-soft"
		schemaUri="http://warp-hash.x4o.distributedrebirth.love/xml/ns/warp-hash-soft-1.0.xsd"
		schemaResource="warp-hash-soft-1.0.xsd" schemaPrefix="soft"
		description="Language namespace to store warp hash"
		name="WarpHash Language Namespace" id="soft">
		<eld:element tag="hash"
			objectClass="love.distributedrebirth.warpme.hash.WaterSoftHash" />
	</eld:namespace>
</root:module>