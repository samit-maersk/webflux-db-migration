ALTER TABLE accounts RENAME COLUMN name TO account_type;
ALTER TABLE accounts ALTER COLUMN account_type SET DATA TYPE account_types USING account_type::account_types;
ALTER TABLE accounts ALTER COLUMN account_type SET DEFAULT 'SAVING_ACCOUNT';