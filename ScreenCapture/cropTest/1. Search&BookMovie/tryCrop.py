from PIL import Image, ImageDraw
import os
import re
import time

image = Image.open("french_flat7.png")
image = image.crop((48, 140, 307, 703))
image.save("french_flat7_small.png")

def recursiveChange(path):
    tempPath = os.listdir(path)
    for pic in tempPath:
        if os.path.isfile(path + "\\" + pic):
            image = Image.open(tempPath + "\\" + pic)
            image = image.crop((48, 140, 307, 703))
            image.save(tempPath + "\\" + pic)
        else:
            recursiveChange(path + "\\" + pic)
    return

recursiveChange(os.getcwd())
