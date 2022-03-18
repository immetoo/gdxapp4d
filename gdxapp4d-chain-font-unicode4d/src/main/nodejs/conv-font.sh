#!/bin/bash

mkdir -p $2;

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

for FILE in `ls $1`
do
	if [[ $FILE == *.ttf ]]; then
		node $SCRIPT_DIR/conv-font.js $1/$FILE > $2/$FILE.xml
	fi
done
