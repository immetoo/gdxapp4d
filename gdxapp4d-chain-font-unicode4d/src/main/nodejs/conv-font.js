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
	
	// JS NOTE: without calling xMin the getContours returns empty set.... :''(
	glyph.xMin;
	var contours = glyph.getContours();
//space is also without contours
//	if (contours.length === 0) {
//		continue; // TODO: add compound support
//	}
	if (glyph.unicodes.length === 0) {
		continue; // with cmds, these are compound glyphs by index base only
	}
	let uni = glyph.unicodes.map(formatUnicode).join(', ');
	
	let xMax = glyph.xMax;
	let yMax = glyph.yMax;
	let xMin = glyph.xMin;
	let yMin = glyph.yMin;
	if (glyph.xMax === undefined) { xMax = 0; }
	if (glyph.yMax === undefined) { yMax = 0; }
	if (glyph.xMin === undefined) { xMin = 0; }
	if (glyph.yMin === undefined) { yMin = 0; }
	
	console.log("\t<glyph unicode=\""+uni+"\" name=\""+glyph.name+"\" advanceWidth=\""+glyph.advanceWidth+"\" "+
		"xMin=\""+xMin+"\" xMax=\""+xMax+"\" yMin=\""+yMin+"\" yMax=\""+yMax+"\" "+
		"leftSideBearing=\""+glyph.leftSideBearing+"\">");
	
	for (let contourIndex = 0; contourIndex < contours.length; ++contourIndex) {
		const contour = contours[contourIndex];
		console.log("\t\t<contour>");
		for (let i = 0; i < contour.length; ++i) {
			let curr = contour[i];
			console.log("\t\t\t<point x=\""+curr.x+"\" y=\""+curr.y+"\" onCurve=\""+curr.onCurve+"\"/>");
		}
		console.log("\t\t</contour>");
	}
	console.log("\t</glyph>");
}
console.log("</opentype>");
