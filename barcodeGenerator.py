import barcode
from barcode.writer import ImageWriter

# Ensure the barcode format 'code128' is correct and supported
try:
	# Choose the barcode format
	CODE = barcode.get_barcode_class('code128')

	# Create the barcode object, passing the data and the writer
	barcode_obj = CODE('123456789012', writer=ImageWriter())

	# Save the barcode as an image
	# The second parameter should be a file path or file-like object
	# The options like 'format' should be passed as separate arguments, not as a dictionary
	barcode_obj.save('barcode_example', options={'format': 'PNG'})

	print("Barcode saved successfully.")
except Exception as e:
	print(f"An error occurred: {e}")