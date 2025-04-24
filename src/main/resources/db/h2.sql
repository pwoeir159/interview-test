CREATE TABLE IF NOT EXISTS currency_info(
	currency_code VARCHAR(3) PRIMARY KEY,
	currency_name_zh VARCHAR(50) NOT NULL,
	currency_name_en VARCHAR(50)
)