<?xml version="1.0" encoding="UTF-8"?>
<root:module xmlns:root="http://eld.x4o.org/xml/ns/eld-root"
	xmlns:eld="http://eld.x4o.org/xml/ns/eld-lang"
	xmlns:conv="http://eld.x4o.org/xml/ns/eld-conv"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://eld.x4o.org/xml/ns/eld-root http://eld.x4o.org/xml/ns/eld-root-1.0.xsd"
	providerHost="warp-sea.x4o.distributedrebirth.love" providerName="WarpSeaᵐᵉ"
	id="warp-sea-module">

	<eld:classBindingHandler id="WaterOcean-WaterSea"
		parentClass="love.distributedrebirth.warpme.sea.WaterOcean"
		childClass="love.distributedrebirth.warpme.sea.WaterSea"
		addMethod="fillWater" getMethod="theWater" />
	<eld:classBindingHandler id="WaterSea-WaterSeaChain"
		parentClass="love.distributedrebirth.warpme.sea.WaterSea"
		childClass="love.distributedrebirth.warpme.sea.WaterSeaChain"
		addMethod="addSeaChain" getMethod="getSeaChains" />
	<eld:classBindingHandler id="WaterSea-Tone"
		parentClass="love.distributedrebirth.warpme.sea.WaterSea"
		childClass="love.distributedrebirth.warpme.sea.WaterSeaMagic"
		addMethod="addSeaMagic" getMethod="getSeaMagics" />
	
	<eld:namespace
		uri="http://wrap-sea.x4o.distributedrebirth.love/xml/ns/warp-sea-root"
		schemaUri="http://warp-sea.x4o.distributedrebirth.love/xml/ns/warp-sea-root-1.0.xsd"
		schemaResource="warp-sea-root-1.0.xsd" schemaPrefix="root"
		description="Root namespace to have nice namespaceing."
		name="WarpSea Root Namespace" languageRoot="true" id="root">
		<eld:element tag="ocean"
			objectClass="love.distributedrebirth.warpme.sea.WaterOcean"/>
	</eld:namespace>

	<eld:namespace
		uri="http://warp-sea.x4o.distributedrebirth.love/xml/ns/warp-sea-link"
		schemaUri="http://warp-sea.x4o.distributedrebirth.love/xml/ns/warp-sea-link-1.0.xsd"
		schemaResource="warp-sea-link-1.0.xsd" schemaPrefix="link"
		description="Language namespace to store warp sea"
		name="WarpSea Language Namespace" id="link">
		<eld:element tag="sea"
			objectClass="love.distributedrebirth.warpme.sea.WaterSea">
			<eld:attribute id="name" writeOrder="0"/>
			<eld:attribute id="provider" writeOrder="1" required="false"/>
			<eld:attribute id="author" writeOrder="2" required="false"/>
		</eld:element>
		<eld:element tag="chain"
			objectClass="love.distributedrebirth.warpme.sea.WaterSeaChain" />
		<eld:element tag="magic"
			objectClass="love.distributedrebirth.warpme.sea.WaterSeaMagic" />
	</eld:namespace>
</root:module>