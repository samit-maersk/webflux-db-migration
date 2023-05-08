CREATE OR REPLACE VIEW user_accounts AS
 SELECT u.id, u.name, u.email, u.account_no, a.account_type, a.balance
 FROM users u, accounts a
 WHERE a.id = u.account_no;