from PIL import Image, ImageEnhance, ImageFilter
import os

path = "./Image Editor/unedited" # folder for unedited images
pathOut = "./Image Editor/edited" # folder for edited images

for filename in os.listdir(path):
    img = Image.open(f"{path}/{filename}")

    # sharpening, BW
    edit = img.filter(ImageFilter.DETAIL).rotate(0)
    
    # brightness
    color_factor = 1.5
    enhancer = ImageEnhance.Color(edit)
    edit = enhancer.enhance(color_factor)

    # contrast
    factor = 1
    enhancer = ImageEnhance.Contrast(edit)
    edit = enhancer.enhance(factor)

    clean_name = os.path.splitext(filename)[0]

    edit.save(f'{pathOut}/{clean_name}_edited.png')
