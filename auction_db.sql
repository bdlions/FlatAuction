CREATE TABLE `bid_times` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `bid_times`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idx_name` (`title`);
ALTER TABLE `bid_times`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;