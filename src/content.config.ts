import { defineCollection } from 'astro:content';
import { glob } from 'astro/loaders';
import { z } from 'astro/zod';

export const collections = {
	articles: defineCollection({
		loader: glob({ base: './src/content/articles', pattern: '**/*.md' }),
		schema: z.object({
			title: z.string(),
			description: z.string(),
			publishDate: z.coerce.date(),
			tags: z.array(z.string()),
			canonicalUrl: z.string().optional(),
		}),
	}),
	work: defineCollection({
		loader: glob({ base: './src/content/work', pattern: '**/*.md' }),
		schema: z.object({
			title: z.string(),
			description: z.string(),
			publishDate: z.coerce.date(),
			tags: z.array(z.string()),
			img: z.string().optional(),
			img_alt: z.string().optional(),
		}),
	}),
	writing: defineCollection({
		loader: glob({ base: './src/content/writing', pattern: '**/*.md' }),
		schema: z.object({
			title: z.string(),
			role: z.string(),
			period: z.string(),
			publishDate: z.coerce.date(),
			description: z.string(),
			tags: z.array(z.string()),
		}),
	}),
};
