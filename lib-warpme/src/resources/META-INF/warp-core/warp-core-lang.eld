<?xml version="1.0" encoding="UTF-8"?>
<root:module xmlns:root="http://eld.x4o.org/xml/ns/eld-root"
	xmlns:eld="http://eld.x4o.org/xml/ns/eld-lang"
	xmlns:conv="http://eld.x4o.org/xml/ns/eld-conv"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://eld.x4o.org/xml/ns/eld-root http://eld.x4o.org/xml/ns/eld-root-1.0.xsd"
	providerHost="warp-core.x4o.distributedrebirth.love" providerName="WarpCoreᵐᵉ"
	id="warp-core-module">

	<eld:classBindingHandler id="Bucket-Water"
		parentClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterBucket"
		childClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipher"
		addMethod="fillWater" getMethod="theWater" />
	<eld:classBindingHandler id="Water-Heart"
		parentClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipher"
		childClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipherHeart"
		addMethod="addCipherHeart" getMethod="getCipherHearts" />
	<eld:classBindingHandler id="Heart-Tone"
		parentClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipherHeart"
		childClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipherHeartTone"
		addMethod="addHeartTone" getMethod="getHeartTones" />
	
	<eld:namespace
		uri="http://wrap-core.x4o.distributedrebirth.love/xml/ns/warp-core-root"
		schemaUri="http://warp-core.x4o.distributedrebirth.love/xml/ns/warp-core-root-1.0.xsd"
		schemaResource="warp-core-root-1.0.xsd" schemaPrefix="root"
		description="Root namespace to have nice namespaceing."
		name="WarpCore Root Namespace" languageRoot="true" id="root">
		<eld:element tag="bucket"
			objectClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterBucket"/>
	</eld:namespace>

	<eld:namespace
		uri="http://warp-core.x4o.distributedrebirth.love/xml/ns/warp-core-cipher"
		schemaUri="http://warp-core.x4o.distributedrebirth.love/xml/ns/warp-core-cipher-1.0.xsd"
		schemaResource="warp-core-lang-1.0.xsd" schemaPrefix="cipher"
		description="Language namespace to store warp cipher"
		name="WarpCore Language Namespace" id="cipher">
		<eld:element tag="water"
			objectClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipher" />
		<eld:element tag="heart"
			objectClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipherHeart" />
		<eld:element tag="tone"
			objectClass="love.distributedrebirth.numberxd.base2t.part.warp.WaterCipherHeartTone" />
	</eld:namespace>
</root:module>