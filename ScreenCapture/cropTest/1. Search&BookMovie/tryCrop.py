from PIL import Image, ImageDraw

image = Image.open("french_flat7.png")
image = image.crop((48, 140, 307, 703))
image.save("french_flat7_small.png")
