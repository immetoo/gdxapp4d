const opentype = require('opentype.js');

const args = process.argv.slice(2);
const font = opentype.loadSync(args[0]);

function formatUnicode(unicode) {
	unicode = unicode.toString(16);
	if (unicode.length > 4) {
		return ("000000" + unicode.toUpperCase()).substr(-6)
	} else {
		return ("0000" + unicode.toUpperCase()).substr(-4)
	}
}

console.log("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
console.log("<opentype>");

let num = font.numGlyphs;
for(let glyphIndex = 0; glyphIndex < num; glyphIndex++) {
	let glyph = font.glyphs.get(glyphIndex);
	
	// JS NOTE: without calling xMin the getContours return empty set.... :''(
	glyph.xMin;
	var contours = glyph.getContours();
	if (contours.length === 0) {
		// TODO: add compound support
		continue;
	}
	if (glyph.unicodes.length === 0) {
		continue; // with cmds, these are compound glyphs
	}
	let uni = glyph.unicodes.map(formatUnicode).join(', ');
	console.log("\t<glyph unicode=\""+uni+"\" name=\""+glyph.name+"\" advanceWidth=\""+glyph.advanceWidth+"\" "+
		"xMin=\""+glyph.xMin+"\" xMax=\""+glyph.xMax+"\" yMin=\""+glyph.yMin+"\" yMax=\""+glyph.yMax+"\" "+
		"leftSideBearing=\""+glyph.leftSideBearing+"\">");
	
	
	for (let contourIndex = 0; contourIndex < contours.length; ++contourIndex) {
		const contour = contours[contourIndex];
		console.log("\t\t<contour>");
		for (let i = 0; i < contour.length; ++i) {
			let curr = contour[i];
			console.log("\t\t\t<point x=\""+curr.x+"\" y=\""+curr.y+"\" onCurve=\""+curr.onCurve+"\"/>");
		}
		console.log("\t\t</contour>");
		//console.log(JSON.stringify(curr));
	}
	/*
	for (i = 0; i < path.commands.length; i += 1) {
		cmd = path.commands[i];
		if (cmd.type === 'M') {
			console.log("\t\t<pathMove x=\""+cmd.x+"\" y=\""+cmd.y+"\"/>");
		} else if (cmd.type === 'L') {
			console.log("\t\t<pathLine x=\""+cmd.x+"\" y=\""+cmd.y+"\"/>");
		} else if (cmd.type === 'C') {
			console.log("\t\t<pathBezierCurve x1=\""+cmd.x1+"\" y1=\""+cmd.y1+"\" x2=\""+cmd.x2+"\" y2=\""+cmd.y2+"\" x=\""+cmd.x+"\" y=\""+cmd.y+"\"/>");
		} else if (cmd.type === 'Q') {
			console.log("\t\t<pathQuadraticCurve x1=\""+cmd.x1+"\" y1=\""+cmd.y1+"\" x=\""+cmd.x+"\" y=\""+cmd.y+"\"/>");
		} else if (cmd.type === 'Z') {
			console.log("\t\t<pathClose/>");
		}
	}
	*/``
	console.log("\t</glyph>");
}
console.log("</opentype>");
