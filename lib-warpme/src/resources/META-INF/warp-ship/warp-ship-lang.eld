<?xml version="1.0" encoding="UTF-8"?>
<root:module xmlns:root="http://eld.x4o.org/xml/ns/eld-root"
	xmlns:eld="http://eld.x4o.org/xml/ns/eld-lang"
	xmlns:conv="http://eld.x4o.org/xml/ns/eld-conv"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://eld.x4o.org/xml/ns/eld-root http://eld.x4o.org/xml/ns/eld-root-1.0.xsd"
	providerHost="warp-ship.x4o.distributedrebirth.love" providerName="WarpShipᵐᵉ"
	id="warp-ship-module">

	<eld:classBindingHandler id="WaterDevice-WaterShip"
		parentClass="love.distributedrebirth.warpme.ship.WaterDevice"
		childClass="love.distributedrebirth.warpme.ship.WaterShip"
		addMethod="buildShip" getMethod="theShip" />
	<eld:classBindingHandler id="WaterShip-WaterShipOcean"
		parentClass="love.distributedrebirth.warpme.ship.WaterShip"
		childClass="love.distributedrebirth.warpme.ship.WaterShipOcean"
		addMethod="addShipOcean" getMethod="getShipOceans" />
	
	<eld:namespace
		uri="http://wrap-ship.x4o.distributedrebirth.love/xml/ns/warp-ship-root"
		schemaUri="http://warp-ship.x4o.distributedrebirth.love/xml/ns/warp-ship-root-1.0.xsd"
		schemaResource="warp-ship-root-1.0.xsd" schemaPrefix="root"
		description="Root namespace to have nice namespaceing."
		name="WarpShip Root Namespace" languageRoot="true" id="root">
		<eld:element tag="device"
			objectClass="love.distributedrebirth.warpme.ship.WaterDevice"/>
	</eld:namespace>

	<eld:namespace
		uri="http://warp-ship.x4o.distributedrebirth.love/xml/ns/warp-ship-boot"
		schemaUri="http://warp-ship.x4o.distributedrebirth.love/xml/ns/warp-ship-boot-1.0.xsd"
		schemaResource="warp-ship-boot-1.0.xsd" schemaPrefix="boot"
		description="Language namespace to store the warp ship."
		name="WarpShip Language Namespace" id="boot">
		<eld:element tag="ship"
			objectClass="love.distributedrebirth.warpme.ship.WaterShip" />
		<eld:element tag="ocean"
			objectClass="love.distributedrebirth.warpme.ship.WaterShipOcean" />
	</eld:namespace>
</root:module>