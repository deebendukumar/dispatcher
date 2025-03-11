from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    PROJECT_NAME: str = "Dispatcher (Warehouse Management System)"
    PROJECT_VERSION: str = "1.0.0"
    API_V1_STR: str = "/pim/api/v1"

    # SMTP Configuration
    SMTP_SERVER: str = "smtp.example.com"
    SMTP_PORT: int = 587
    SMTP_USERNAME: str = "your-username"
    SMTP_PASSWORD: str = "your-password"
    EMAIL_FROM: str = "your-email@example.com"
    EMAIL_FROM_NAME: str = "Dispatcher"

    # User settings
    CACHE_SIZE_MB: int = 100
    LOG_LEVEL: str = "INFO"

    class Config:
        env_file = ".env"

settings = Settings();